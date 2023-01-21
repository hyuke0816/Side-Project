package com.example.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.backend.model
 * fileName : Goods
 * author : hyuk
 * date : 2023/01/21
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/21         hyuk          최초 생성
 */

@Entity
@SequenceGenerator(
        name= "SQ_GOODS_GENERATOR"
        , sequenceName = "SQ_GOODS"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_GOODS")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
// TODO: @Where, @SQLDelete 추가, BaseTimeEntity 상속
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_GOODS SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE GID = ?")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                    ,generator = "SQ_GOODS_GENERATOR"
    )
    @Column
    private Integer gid;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column
    private String explanation;

    @Column
    private String mainPhoto;

    @Column
    private Integer views;

    @Column
    private Integer purchase;

    @Column
    private Integer reviews;

    @Column
    private String publishDay;

    @Column
    private String publishYn;

}
