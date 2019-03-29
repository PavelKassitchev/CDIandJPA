package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "WEBER", schema = "PUBLIC", catalog = "H2DB")
public class WeberEntity {
    private int number;
    private String name;
    private String answers;

    @Id
    @Column(name = "NUMBER")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ANSWERS")
    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeberEntity that = (WeberEntity) o;
        return number == that.number &&
                Objects.equals(name, that.name) &&
                Objects.equals(answers, that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, answers);
    }
}
