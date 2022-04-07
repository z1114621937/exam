package com.admin.service.impl;

import com.admin.service.StudentImplService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Answer;
import com.mbg.exam.entity.Student;
import com.mbg.exam.mapper.AnswerMapper;
import com.mbg.exam.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-14
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentImplService {




    @Autowired
  private   AnswerMapper answerMapper;


    /**
     * 查询所有学生所有信息
     * @return
     */
    public CommonResult queryStudentList() {
        QueryWrapper<Student> wrapper = new QueryWrapper();
        List<Student> studentList=baseMapper.selectList(wrapper);
        studentList.forEach(System.out::println);
        if (!studentList.isEmpty())
            return CommonResult.success(studentList,"查看所有学生成功");
        else
            return  CommonResult.failed("查询失败");
    }

    /**
     * 删除一个学生
     */
    public  CommonResult  deleteStudent(String username)
    {
        QueryWrapper<Student> wrapper= new QueryWrapper<>();
        wrapper.eq("username",username);
        int result=baseMapper.delete(wrapper);
        if(result>0)
            return  CommonResult.success(result,"删除学生成功");
        else
            return  CommonResult.failed("删除学生失败");
    }

    /**
     * 查看单个学生详细信息成功
     * @param username
     * @return
     */
    public  CommonResult<Student>selectStudentByUsername(String username)
    {
        QueryWrapper<Student> wrapper= new QueryWrapper<>();
        wrapper.eq("username",username);
        Student student=baseMapper.selectOne(wrapper);
        System.out.println(student);
        if(student!=null)
        {
            return  CommonResult.success(student,"查询成功");
        }
        return  CommonResult.failed("查询失败");
    }


    /**
     * 添加学生
     * @param username
     * @return
     */
    public  CommonResult addStudent(String name,String username,String password,String school,String classes)
    {
        Student student=new Student();
        student.setName(name);
        student.setUsername(username);
        student.setPassword(password);
        student.setSchool(school);
        student.setClasses(classes);
        int result=baseMapper.insert(student);
        if(result>1)
        {
            return  CommonResult.success("添加成功");
        }
        return  CommonResult.failed("添加成功");
    }

    //todo  学生答题

    /**
     * 开始考试  插入answer表 连接答案和试卷
     * @param map
     * @return
     */
    @Override
    public CommonResult writePaper(Map map) {
        Answer answer=new Answer();
        answer.setPaperId((String) map.get("paper_id"));
        answer.setStuId((String) map.get("stu_id"));
        answer.setIsTrue(Integer.parseInt((String) map.get("is_true")));
        List<String> list = (List) map.get("ks_answer");
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            Object lo = list.get(i);
            Map entry = (Map) lo;
           // System.out.println(lo);
          //  System.out.println(entry);
         //   System.out.println(entry.get("answer"));
            answer.setAnswer2(null);
            answer.setAnswer3(null);
            answer.setAnswer4(null);
            answer.setAnswer5(null);
            answer.setState(Integer.parseInt((String) entry.get("state")));
            answer.setAnswer((String) entry.get("answer"));
            System.out.println(entry.size());
            if (entry.size()==2)
            {
               // System.out.println(entry.get("answer2"));
                answer.setAnswer2((String) entry.get("answer2"));
            }
            else if (entry.size()==3)
            {
                answer.setAnswer2((String) entry.get("answer2"));
                answer.setAnswer3((String) entry.get("answer3"));
             //   System.out.println(entry.get("answer2"));
            //    System.out.println(entry.get("answer3"));
            }
            else if (entry.size()==4)
            {
                answer.setAnswer2((String) entry.get("answer2"));
                answer.setAnswer3((String) entry.get("answer3"));
                answer.setAnswer4((String) entry.get("answer4"));
             //   System.out.println(entry.get("answer2"));
            //    System.out.println(entry.get("answer3"));
              //  System.out.println(entry.get("answer4"));
            }
            else if (entry.size()==5)
            {
                answer.setAnswer2((String) entry.get("answer2"));
                answer.setAnswer3((String) entry.get("answer3"));
                answer.setAnswer4((String) entry.get("answer4"));
                answer.setAnswer5((String) entry.get("answer5"));

             //   System.out.println(entry.get("answer2"));
            //    System.out.println(entry.get("answer3"));
             //   System.out.println(entry.get("answer4"));
             //   System.out.println(entry.get("answer5"));
            }
          //  answer.setAnswer((String) map.get("state"));
            answerMapper.insert(answer);
        }
        return CommonResult.success("答题提交成功");
    }



    @Override
    public CommonResult<List> studentPaper(int paper_id, int stu_id) {
     List list=answerMapper.getpaperandanswer(paper_id,stu_id);
       return CommonResult.success(list,"查看成功");
    }

 /*   select * from ks_answer,ks_paper left join ks_paper on ks_answer.paper_id=ks_paper.id
    where ks_answer.paper_id=#{paper_id} and ks_answer.stu_id=#{stu_id}*/


}
