package com.BRIS.Login.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_no")
    private Long Id;

    @Column(name = "history_table", nullable = false)
    private String historyTable;

    /*@Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;*/

    public History() {}

    public History(String historyTable) {
        this.historyTable = historyTable;
        //this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getHistoryTable() {
        return historyTable;
    }
    public void setHistoryTable(String historyTable) {
        this.historyTable = historyTable;
    }

    /*public LocalDateTime getTimeStamp() {
        return timestamp;
    }
    public void setTimeStamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }*/

}
