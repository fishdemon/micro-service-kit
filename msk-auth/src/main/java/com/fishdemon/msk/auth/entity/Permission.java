package com.fishdemon.msk.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author Anjin.Ma
 * @since 2020-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_permission")
@ApiModel(value="Permission对象", description="")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父编号,本权限可能是该父编号权限的子权限")
    private Integer parentId;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view")
    private String code;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "资源类型，[menu|button|api]")
    private String type;

    @ApiModelProperty(value = "资源路径 如：/userinfo/list")
    private String url;

    @ApiModelProperty(value = "请求方法 get/post/put/delete")
    private String method;

    @ApiModelProperty(value = "顺序")
    private Integer sort;

    @ApiModelProperty(value = "删除状态：0:已删除 1:正常")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "最后更新时间")
    private Date updateTime;


}
