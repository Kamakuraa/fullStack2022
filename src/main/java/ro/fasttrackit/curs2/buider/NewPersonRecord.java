package ro.fasttrackit.curs2.buider;

import lombok.Builder;


@Builder
public record NewPersonRecord (String name, int age){
}
