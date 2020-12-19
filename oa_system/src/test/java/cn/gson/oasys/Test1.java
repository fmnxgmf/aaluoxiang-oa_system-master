package cn.gson.oasys;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import cn.gson.oasys.mappers.NoticeMapper;
import cn.gson.oasys.model.dao.attendcedao.AttendceService;
import cn.gson.oasys.model.dao.processdao.NotepaperDao;
import cn.gson.oasys.model.dao.user.UserDao;
import org.springframework.util.ResourceUtils;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {
    @Autowired
    private NotepaperDao notepaperDao;

    @Autowired
    private NoticeMapper nm;

    @Autowired
    AttendceService attendceService;
    @Autowired
    UserDao uDao;

    @Test
    public void test() {
        PageHelper.startPage(0, 10);
        List<Map<String, Object>> list = nm.findMyNotice(1L);
        PageInfo<Map<String, Object>> info = new PageInfo<Map<String, Object>>(list);
        System.out.println(info);
    }

    @Test
    public void test2() {
        String str = "罗祥";
        try {
            System.out.println(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITH_TONE_MARK));
            System.out.println(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITH_TONE_NUMBER));
            System.out.println(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITHOUT_TONE));
            System.out.println(PinyinHelper.getShortPinyin(str));
        } catch (PinyinException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Test
    public void demo() throws FileNotFoundException {
       String rootPath= ResourceUtils.getURL("classpath:").getPath().replace("target/classes/","static/file");
        System.out.println("rootPath = " + rootPath);
        System.out.println(ResourceUtils.getURL("classpath:").getPath());
    }
    @Test
    public void path(){
        String path = this.getClass().getResource("/static/images/gai.gif").getPath();
        String path1 = this.getClass().getResource("/").getPath();
        System.out.println("path1 = " + path1);
        System.out.println("path = " + path);
    }
    @Test
    public void file() {
        String f1 = "E:";
        String f2 = "git";
        File file = new File(f1,f2);
        System.out.println("file = " + file);
    }
    @Test
    public void de(){
        List list = new ArrayList();
        list.add(1); list.add(2);
        list.add(4); list.add(3);
        list.add(5); list.add(6);
        list.add(8); list.add(7);
        list.add(9); list.add(10);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
