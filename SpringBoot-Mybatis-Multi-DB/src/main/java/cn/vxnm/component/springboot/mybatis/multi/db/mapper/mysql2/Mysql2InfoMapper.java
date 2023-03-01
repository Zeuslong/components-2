package cn.vxnm.component.springboot.mybatis.multi.db.mapper.mysql2;

import cn.vxnm.component.springboot.mybatis.multi.db.model.InfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Mysql2InfoMapper {

    int insert(InfoModel infoModel);

    List<InfoModel> selectAll();
}
