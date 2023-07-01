package ru.simakov;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@MappedSuperclass
public abstract class BaseEntityC extends BaseEntity {

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @PrePersist
    void prePersist() {
        this.createDate = LocalDateTime.now();
    }
}
