package com.example.demo.dao;

import com.example.demo.entity.Show;
import org.apache.ibatis.annotations.Insert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowDaoTest {
    @Autowired
    private ShowDao showDao;

    @Test
    @Ignore
    public void queryShow(){
        List<Show> showList = showDao.queryShow();
        assertEquals(1 ,showList.size());
    }
    @Test
    @Ignore
    public void queryShowByName(){
        List<Show> showList = showDao.queryShowByName("杰");
        assertEquals(2,showList.size());

    }

    @Test
    @Ignore
    public void queryShowBySite(){
       List<Show> showList = showDao.queryShowBySite("西安");
        assertEquals(2,showList.size());
    }

    @Test
    @Ignore
    public void queryShowByType(){
        List<Show> showList = showDao.queryShowByType("曲艺杂谈");
        assertEquals(2,showList.size());
    }

    @Test
    @Ignore
    public void insertShow(){
        Show show = new Show();
        show.setShowName("2019英雄联盟MSI冠军挑战赛");
        show.setShowSite("武汉");
        show.setShowIntroduction("群雄逐鹿，试看IG能否再创辉煌");
        show.setShowType("体育赛事");
        int effectedNum = showDao.insertShow(show);
        assertEquals(2,effectedNum);

    }

    @Test
    @Ignore
    public void updateShow(){
        Show show = new Show();
        show.setShowSite("西安");
        show.setShowId(4);
        int effectedNum = showDao.updateShow(show);
        assertEquals(1,effectedNum);

    }
    @Test
    @Ignore
    public void deleteShow(){
        int effectedNum = showDao.deleteShow(4);
        assertEquals(1,effectedNum);

    }

    @Test
    @Ignore
    public void insert(){
        Show show = new Show();
        show.setShowName("jhahahha2019英雄联盟MSI冠军挑战赛");
        show.setShowSite("武汉hahah");
        show.setShowIntroduction("群雄逐鹿，试看IG能否再创辉煌");
        show.setShowType("体育赛事");
        showDao.insert(show);

    }
}
