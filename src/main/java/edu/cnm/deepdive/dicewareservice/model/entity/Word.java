package edu.cnm.deepdive.dicewareservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

@Entity
@JsonIgnoreProperties({"id", "passphrase"})
public class Word {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "word_id", nullable = false, updatable = false)
  private Long id;

  @Column(nullable = false, updatable = false)
  private String word;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "passphrase_id", nullable = false, updatable = false)
  private edu.cnm.deepdive.dicewareservice.model.entity.Passphrase passphrase;

  public Long getId() {
    return id;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public edu.cnm.deepdive.dicewareservice.model.entity.Passphrase getPassphrase() {
    return passphrase;
  }

  public void setPassphrase(edu.cnm.deepdive.dicewareservice.model.entity.Passphrase passphrase) {
    this.passphrase = passphrase;
  }

}
