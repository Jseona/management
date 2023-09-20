package com.mall.management.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //Entity 처리시 날짜 처리
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;

    @Column(length = 200)
    private String pname;

    @Column(length = 10)
    private int quan;

    @Column(length = 10)
    private int price;

    @CreatedDate
    @Column
    private LocalDateTime pdate;

    public void changePname(String pname) {
        this.pname = pname;
    }

    public void changePquan(int quan) {
        this.quan = quan;
    }

    public void changePrice(int price) {
        this.price = price;
    }

    public void change(String pname, int quan, int price) {
        changePname(pname);
        changePquan(quan);
        changePrice(price);
    }


}
