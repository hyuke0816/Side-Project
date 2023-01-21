package com.example.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

/**
 * packageName : com.example.backend.model
 * fileName : User
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
        name = "SQ_USER_GENERATOR"
        , sequenceName = "SQ_USER"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_USER",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "USERNAME"),
                @UniqueConstraint(columnNames = "EMAIL")
        })
@Getter
@Setter
@ToString(exclude = "role")
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql = "UPDATE TB_USER SET DELETE_YN = 'Y', DELETE_TIME=TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE ID = ?")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_USER_GENERATOR"
    )
    @Column
    private Long id;

    @NotBlank
    @Column
    private String username;

    @NotBlank
    @Column
    private String password;

    @NotBlank
    @Column
    private String name;

    @NotBlank
    @Column
    private String email;

    @NotBlank
    @Column
    private String birth;

    @NotBlank
    @Column
    private String phone;

    @NotBlank
    @Column
    private String address;

    @NotBlank
    @Column
    private String gender;


//    TODO: 테이블 매핑
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "TB_USER_ROLE",
    joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> role = new HashSet<>();


    public User(String username, String password, String name, String email, String birth, String phone, String address, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public User(Long id, String username, String password, String name, String email, String birth, String phone, String address, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }
}
