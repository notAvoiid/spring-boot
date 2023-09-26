package br.com.mrzoom.restwithspringbootandjava.integrationtests.vo.wrappers;

import br.com.mrzoom.restwithspringbootandjava.integrationtests.vo.PersonVO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PersonEmbeddedVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("personVOList")
    private List<PersonVO> people;

    public PersonEmbeddedVO() {}

    public List<PersonVO> getPeople() {
        return people;
    }

    public void setPeople(List<PersonVO> people) {
        this.people = people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEmbeddedVO that = (PersonEmbeddedVO) o;

        return Objects.equals(people, that.people);
    }

    @Override
    public int hashCode() {
        return people != null ? people.hashCode() : 0;
    }
}
