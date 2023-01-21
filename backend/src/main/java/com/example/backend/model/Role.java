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
 * fileName : Role
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
        name= "SQ_ROLE_GENERATOR"
        , sequenceName = "SQ_ROLE"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_ROLE")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
// TODO: @Where, @SQLDelete 추가, BaseTimeEntity 상속
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_ROLE SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE RID = ?")
public class Role extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                    ,generator = "SQ_ROLE_GENERATOR"
    )
    @Column
    private Integer rid;

    @Enumerated(EnumType.STRING)
    @Column
    private ERole roleName;

    public Role(ERole roleName) { this.roleName = roleName; }

}
