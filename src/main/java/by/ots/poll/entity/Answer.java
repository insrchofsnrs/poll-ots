package by.ots.poll.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "answer_id")
    private Long id;
    private String vote;
    @Column(name = "COUNT", columnDefinition = "INTEGER DEFAULT 0")
    private Integer count = 0;
    @Column(name = "poll_id", insertable = false, updatable = false)
    private Long pollId;
}
