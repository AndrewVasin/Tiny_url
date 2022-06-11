package ru.tinyurl.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "notations")
@Getter
@Setter
public class Notation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tiny_url", length = 20, nullable = false, unique = true)
    private String tinyUrl;

    @Column(name = "full_url", length = 512, nullable = false, unique = true)
    private String fullUrl;

    @Column(name = "description", length = 256, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Notation() {
    }

    public Notation(String tinyUrl, String fullUrl, String description, User user) {
        this.tinyUrl = tinyUrl;
        this.fullUrl = fullUrl;
        this.description = description;
        this.user = user;
    }
}
