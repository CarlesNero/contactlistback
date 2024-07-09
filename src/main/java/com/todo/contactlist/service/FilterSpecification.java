package com.todo.contactlist.service;

import com.todo.contactlist.dto.RequestDto;
import com.todo.contactlist.dto.SearchRequestDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterSpecification<T> {
    public Specification<T> getSearchSpecification(SearchRequestDto searchRequestDto) {
        return new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(searchRequestDto.getColumn()), searchRequestDto.getValue());
            }
        };
    }

    public Specification<T> getSearchSpecification(List<SearchRequestDto> searchRequestDtoList,
                                                   RequestDto.GlobalOperator globalOperator) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
          for(SearchRequestDto requestDto : searchRequestDtoList) {


              switch (requestDto.getOperation()){
                  case EQUAL:
                      Predicate equal =  criteriaBuilder.equal(root.get(requestDto.getColumn()), requestDto.getValue());
                      predicates.add(equal);
                      break;
                  case LIKE:
                      Predicate like =  criteriaBuilder.equal(root.get(requestDto.getColumn()), "%" + requestDto.getValue() + "%");
                      predicates.add(like);
                      break;
                  default: throw new IllegalStateException("Unexpected value: " + "");
              }
          }
          if(globalOperator.equals(RequestDto.GlobalOperator.AND)) {
          return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
          }else{
              return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
          }
        };
    }
}