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

    public Specification<T> getSearchSpecification(List<SearchRequestDto> searchRequestDtos,
                                                   RequestDto.GlobalOperator globalOperator) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
          for(SearchRequestDto requestDto : searchRequestDtos) {


              switch (requestDto.getOperation()){
                  case EQUAL:
                      Predicate equal =  criteriaBuilder.equal(root.get(requestDto.getColumn()), requestDto.getValue());
                      predicates.add(equal);
                      break;
                  case LIKE:
                      Predicate like = criteriaBuilder.like(root.get(requestDto.getColumn()), "%" + requestDto.getValue() + "%");
                      predicates.add(like);
                      break;
                  case IN:
                      String[] split = requestDto.getValue().split(",");
                      Predicate in = root.get(requestDto.getColumn()).in(split);
                      predicates.add(in);
                      break;
                  case LESS_THAN:
                      Predicate lessThan = criteriaBuilder.lessThan(root.get(requestDto.getColumn()), requestDto.getValue());
                      predicates.add(lessThan);
                        break;
                  case GREATER_THAN:
                      Predicate greaterThan = criteriaBuilder.greaterThan(root.get(requestDto.getColumn()), requestDto.getValue());
                      predicates.add(greaterThan);
                      break;
                  case BETWEEN:
                      String[] split1 = requestDto.getValue().split(",");
                      Predicate between = criteriaBuilder.between(root.get(requestDto.getColumn()),Long.parseLong(split1[0]),Long.parseLong(split1[1]));
                      predicates.add(between);
                      break;
                  case JOIN:
                      Predicate join = criteriaBuilder.equal(root.join(requestDto.getJoinTable()).get(requestDto.getColumn()), requestDto.getValue());
                      predicates.add(join);
                      break;
                  default:
                      throw new IllegalStateException("Unexpected value: " + "");
              }
          }
          if(globalOperator.equals(RequestDto.GlobalOperator.AND)) {
          return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
          }else{
              return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
          }
        };
    }
}