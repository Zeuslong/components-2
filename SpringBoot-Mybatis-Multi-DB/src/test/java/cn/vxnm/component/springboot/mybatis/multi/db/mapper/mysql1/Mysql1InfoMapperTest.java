package cn.vxnm.component.springboot.mybatis.multi.db.mapper.mysql1;

import cn.vxnm.component.springboot.mybatis.multi.db.model.InfoModel;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Mysql1InfoMapperTest {

    @Autowired
    private Mysql1InfoMapper mysql1InfoMapper;

    @org.junit.Test
    public void run() {

        // write into db
        InfoModel infoModel = new InfoModel();
        infoModel.setInfo("this is mysql 1");
        infoModel.setCreateTime(LocalDateTime.now());

        System.out.println(mysql1InfoMapper.insert(infoModel));

        // read from db
        List<InfoModel> infoModels = mysql1InfoMapper.selectAll();
        for (InfoModel info : infoModels) {
            System.out.println(info);
        }
    }
}