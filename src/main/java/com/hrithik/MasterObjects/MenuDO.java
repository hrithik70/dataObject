package com.hrithik.MasterObjects;

import com.hrithik.base.BaseMasterDO;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "MENU")
public class MenuDO extends BaseMasterDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "menuCd")
    private String menuCd;
    @Column(name = "menuName")
    private String menuName;
    @Column(name = "userRole")
    private String userRole;
    @Column(name = "icon")
    private String icon;
    @Column(name = "url")
    private String url;
    @Column(name = "sortOrder")
    private Integer sortOrder;

    @JoinColumn(name = "parentMenuCd")
    @OneToMany(orphanRemoval = true,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    List<ChildMenuDO> childMenus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ChildMenuDO> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<ChildMenuDO> childMenus) {
        this.childMenus = childMenus;
    }

    public String getMenuCd() {
        return menuCd;
    }

    public void setMenuCd(String menuCd) {
        this.menuCd = menuCd;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String getObjectName() {
        return MenuDO.class.getSimpleName();
    }
}
