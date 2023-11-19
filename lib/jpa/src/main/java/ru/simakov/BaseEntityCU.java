package ru.simakov;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
public abstract class BaseEntityCU extends BaseEntityC {

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @PreUpdate
    void preUpdate() {
        this.updateDate = LocalDateTime.now();
    }
}
