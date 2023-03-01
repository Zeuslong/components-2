package cn.vxnm.component.springboot.mybatis.multi.db.mapper.mysql2;

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
public class Mysql2InfoMapperTest {


    @Autowired
    private Mysql2InfoMapper mysql2InfoMapper;

    @org.junit.Test
    public void run() {

        // write into db
        InfoModel infoModel = new InfoModel();
        infoModel.setInfo("this is mysql 2");
        infoModel.setCreateTime(LocalDateTime.now());

        System.out.println(mysql2InfoMapper.insert(infoModel));

        // read from db
        List<InfoModel> infoModels = mysql2InfoMapper.selectAll();
        for (InfoModel info : infoModels) {
            System.out.println(info);
        }
    }
}