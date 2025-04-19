package com.hrithik.MasterObjects;

import com.hrithik.base.BaseMasterDO;
import jakarta.persistence.*;

@Entity
@Table(name = "CHILD_MENU")
public class ChildMenuDO extends BaseMasterDO {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return ChildMenuDO.class.getSimpleName();
    }
}
