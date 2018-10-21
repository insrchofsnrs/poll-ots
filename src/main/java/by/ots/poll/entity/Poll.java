package by.ots.poll.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ToString
@Data
@NoArgsConstructor
@Entity
@Table(name = "poll")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poll_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy ="poll", cascade = CascadeType.ALL)
   // @JoinColumn(name = "answer_id")
    private Set<Answer> answersList;
}
