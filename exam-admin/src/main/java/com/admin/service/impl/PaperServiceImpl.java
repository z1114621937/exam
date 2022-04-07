package com.admin.service.impl;


import com.admin.service.PaperImplService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;


import com.mbg.exam.entity.*;
import com.mbg.exam.entity.Class;
import com.mbg.exam.mapper.*;
import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperImplService {
    @Autowired
    private RecordingMapper recordingMapper;

    @Autowired
    private ChooseFuMapper chooseFuMapper;


    @Autowired
    private ChooseMapper chooseMapper;

    @Autowired
    private FillFuMapper fillFuMapper;


    @Autowired
    private  FillMapper fillMapper;

    @Autowired
    private YueFuMapper yueFuMapper;

    @Autowired
    private YueMapper yueMapper;

    @Autowired
    private PaperMapper paperMapper;


    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private ClassPaperMapper classPaperMapper;

    @Autowired
    private SchoolMapper  schoolMapper;


    @Autowired
    private FenFuMapper fenFuMapper;


    @Autowired
    private  FenMapper fenMapper;

    @Autowired
    private MingciFuMapper  mingciFuMapper;

  @Autowired
     private  MingciMapper mingciMapper;

    @Autowired
    private ListenFuMapper listenFuMapper;

    @Autowired
    private  ListenMapper listenMapper;


    @Autowired
    private   FullInputFuMapper fullInputFuMapper;


    @Autowired
    private FullInputMapper fullInputMapper;


    /**
     * 创建试卷
     * @param map
     * @return
     */
    @SneakyThrows
    @Override
    public CommonResult createPaper(Map map) {
        Paper paper = new Paper();
        paper.setExamName((String) map.get("exam_name"));
        paper.setManner((String) map.get("manner"));
        paper.setTeaName((String) map.get("tea_name"));
        paper.setScore(Integer.parseInt((String) map.get("score")));
        paper.setSubject((String) map.get("subject"));
        paper.setState(0);
        paper.setExamTime((String) map.get("exam_time"));
        int result=baseMapper.insert(paper);
        //拿试卷id
      //  System.out.println(paper.getId());
        //设置题目优先级
        int ex_level=0;
        List<String> list = (List) map.get("ks_recording");

       // System.out.println(list); //数组中的对象数
       // System.out.println(list.size());
        //取出每个对象
        for (int i = 0; i < list.size(); i++) {
            Object lo = list.get(i);
            ex_level++;
          System.out.println("---------" + lo + "--------------");
            Map entry = (Map) lo;
            Recording recording = new Recording();
            int type=Integer.parseInt((String) entry.get("type"));
            int Exid=999;
            //拿到这个对象的类型  1
            if(type==1||type==2)
            {
                Choose choose=new Choose();
                choose.setCtSubject((String) map.get("subject"));
                choose.setCtQuestion((String) entry.get("c_question"));
                choose.setCtAnswera((String) entry.get("c_answerA"));
                choose.setCtAnswerb((String) entry.get("c_answerB"));
                choose.setCtAnswerc((String) entry.get("c_answerC"));
                choose.setCtAnswerd((String) entry.get("c_answerD"));
                choose.setCtRight((String) entry.get("c_right"));
                choose.setCtAnalysis((String)entry.get("c_analysis"));
                choose.setCtScore(Integer.parseInt((String) entry.get("c_score")));
               // chooseFu.setCScore((int)entry.get("c_score"));
                choose.setCtLevel((String)entry.get("c_level"));
                if(type==1)  choose.setCtState(1);
              else  choose.setCtState(1);
                  chooseMapper.insert(choose);
                Exid=choose.getId();
            }
            //判断题，简答   1
            else if(type==3||type==4)
            {
                Fill fill=new Fill();
                fill.setFtSubject((String) map.get("subject"));
                fill.setFtQuestion((String)  entry.get("fi_question"));
                fill.setFtRight((String)  entry.get("fi_right"));
                fill.setFtAnalysis((String)  entry.get("fi_analysis"));
                fill.setFtScore(Integer.parseInt((String) entry.get("fi_score")));
                if(type==3)  fill.setFtState(1);
                else  fill.setFtState(2);
           //     fillFu.setFiScore((int)  entry.get("fi_score"));
                fill.setFtLevel((String)  entry.get("fi_level"));
                 fillMapper.insert(fill);
                 Exid=fill.getId();
            }
            //阅读理解. 1
            else if(type==5)
            {
                //1个小题
                System.out.println("---------------------------------------------"+entry.size());
                Yue yue=new Yue();
                yue.setYueSubject((String) map.get("subject"));
                yue.setYueQuestion((String)  entry.get("yue_question"));

                yue.setYueScore(Integer.parseInt((String) entry.get("yue_score")));
                yue.setYueAnalysis((String)  entry.get("yue_analysis"));
                yue.setYueLevel((String)  entry.get("yue_level"));

                yue.setYueQue1((String)  entry.get("yue_que1"));
                yue.setYueAnswer1((String)  entry.get("yue_answer1"));
                yue.setYueRight1((String)  entry.get("yue_right1"));

                //2个小题
                if (entry.size()>8)
                {
                    yue.setYueQue2((String)  entry.get("yue_que2"));
                    yue.setYueAnswer2((String)  entry.get("yue_answer2"));
                    yue.setYueRight2((String)  entry.get("yue_right2"));

                }
                 if(entry.size()>11)
                {
                    yue.setYueQue3((String)  entry.get("yue_que3"));
                    yue.setYueAnswer3((String)  entry.get("yue_answer3"));
                    yue.setYueRight3((String)  entry.get("yue_right3"));
                }
                if(entry.size()>14)
                {
                    yue.setYueQue4((String)  entry.get("yue_que4"));
                    yue.setYueAnswer4((String)  entry.get("yue_answer4"));
                    yue.setYueRight4((String)  entry.get("yue_right4"));
                }

                if(entry.size()>17)
                {
                    yue.setYueQue5((String)  entry.get("yue_que5"));
                    yue.setYueAnswer5((String)  entry.get("yue_answer5"));
                    yue.setYueRight5((String)  entry.get("yue_right5"));
                }
                 yueMapper.insert(yue);
                Exid=yue.getId();
            }
            //分录，资料 1
            else if(type==6||type==7)
            {
                Fen fen=new Fen();
                fen.setFenSubject((String) map.get("subject"));
                fen.setFenQuestion((String)  entry.get("fen_question"));
                fen.setFenAnswer1((String)  entry.get("fen_answer1"));
                fen.setFenRight1((String)  entry.get("fen_right1"));
                fen.setFenAnswer2((String)  entry.get("fen_answer2"));
                fen.setFenRight2((String)  entry.get("fen_right2"));
                fen.setFenAnswer3((String)  entry.get("fen_answer3"));
                fen.setFenRight3((String)  entry.get("fen_right3"));
                fen.setFenAnswer4((String)  entry.get("fen_answer4"));
                fen.setFenRight4((String)  entry.get("fen_right4"));
                fen.setFenAnswer5((String)  entry.get("fen_answer5"));
                fen.setFenRight5((String)  entry.get("fen_right5"));
                fen.setFenAnalysis((String)  entry.get("fen_analysis"));
                fen.setFenScore(Integer.parseInt((String) entry.get("fen_score")));
                fen.setFenLevel((String)  entry.get("fen_level"));
                if(type==6)  fen.setFState(1);
                else  fen.setFState(2);
                fenMapper.insert(fen);
                Exid=fen.getId();
            }
            //名词解析,论述,计算题,简答,口语  1
            else if(type==8||type==9||type==10||type==11||type==12)
            {
                Mingci mingci=new Mingci();
                mingci.setMtSubject((String) map.get("subject"));
                mingci.setMtQuestion((String) entry.get("mi_question"));
                mingci.setMtRight((String)  entry.get("mi_right"));
                mingci.setMtAnalysis((String)  entry.get("mi_analysis"));
                mingci.setMtScore(Integer.parseInt((String) entry.get("mi_score")));
                mingci.setMtLevel((String) entry.get("mi_level"));
                if(type==8)  mingci.setMtState(1);
                else if(type==9)  mingci.setMtState(2);
                else if(type==10)  mingci.setMtState(3);
                else if(type==11)  mingci.setMtState(4);
                else  if(type==12)  mingci.setMtState(5);
                mingciMapper.insert(mingci);
                Exid=mingci.getId();
            }
            //听力  1
            else if(type==13)
            {
                Listen listen= new Listen();
                listen.setLtSubject((String) map.get("subject"));
                listen.setLtData((String)  entry.get("li_data"));
                listen.setLtQuestion((String)  entry.get("li_question"));
                listen.setLtAnswera((String)  entry.get("li_answerA"));
                listen.setLtAnswerb((String)  entry.get("li_answerB"));
                listen.setLtAnswerc((String)  entry.get("li_answerC"));
                listen.setLtAnswerd((String)  entry.get("li_answerD"));
                listen.setLtRight((String)  entry.get("li_right"));
                listen.setLtAnalysis((String)  entry.get("li_analysis"));
                listen.setLtScore(Integer.parseInt((String) entry.get("li_score")));
                listen.setLtLevel((String)  entry.get("li_level"));
                 listenMapper.insert(listen);
                Exid=listen.getId();
            }
            //14完型  1
            else if(type==14)
            {
                FullInput fullInputFu=new FullInput();
                fullInputFu.setFutSubject((String) map.get("subject"));
                fullInputFu.setFutData((String)  entry.get("in_data"));
                fullInputFu.setFutAnalysis((String)  entry.get("in_analysis"));
                fullInputFu.setFutLevel((String)  entry.get("in_level"));
                fullInputFu.setFutScore(Integer.parseInt((String) entry.get("in_score")));

                fullInputFu.setAnswer1a((String) entry.get("answer1A"));
                fullInputFu.setAnswer1b((String) entry.get("answer1B"));
                fullInputFu.setAnswer1c((String) entry.get("answer1C"));
                fullInputFu.setAnswer1d((String) entry.get("answer1D"));
                fullInputFu.setRight1((String) entry.get("right1"));
                fullInputFu.setAnswer2a((String) entry.get("answer2A"));
                fullInputFu.setAnswer2b((String) entry.get("answer2B"));
                fullInputFu.setAnswer2c((String) entry.get("answer2C"));
                fullInputFu.setAnswer2d((String) entry.get("answer2D"));
                fullInputFu.setRight2((String) entry.get("right2"));
                fullInputFu.setAnswer3a((String) entry.get("answer3A"));
                fullInputFu.setAnswer3b((String)entry.get("answer3B"));
                fullInputFu.setAnswer3c((String) entry.get("answer3C"));
                fullInputFu.setAnswer3d((String) entry.get("answer3D"));
                fullInputFu.setRight3((String) entry.get("right3"));
                fullInputFu.setAnswer4a((String) entry.get("answer4A"));
                fullInputFu.setAnswer4b((String) entry.get("answer4B"));
                fullInputFu.setAnswer4c((String) entry.get("answer4C"));
                fullInputFu.setAnswer4d((String) entry.get("answer4D"));
                fullInputFu.setRight4((String) entry.get("right4"));
                fullInputFu.setAnswer5a((String) entry.get("answer5A"));
                fullInputFu.setAnswer5b((String)entry.get("answer5B"));
                fullInputFu.setAnswer5c((String) entry.get("answer5C"));
                fullInputFu.setAnswer5d((String) entry.get("answer5D"));
                fullInputFu.setRight5((String) entry.get("right5"));
                fullInputFu.setAnswer6a((String) entry.get("answer6A"));
                fullInputFu.setAnswer6b((String) entry.get("answer6B"));
                fullInputFu.setAnswer6c((String) entry.get("answer6C"));
                fullInputFu.setAnswer6d((String) entry.get("answer6D"));
                fullInputFu.setRight6((String) entry.get("right6"));
                fullInputFu.setAnswer7a((String) entry.get("answer7A"));
                fullInputFu.setAnswer7b((String) entry.get("answer7B"));
                fullInputFu.setAnswer7c((String) entry.get("answer7C"));
                fullInputFu.setAnswer7d((String)entry.get("answer7D"));
                fullInputFu.setRight7((String) entry.get("right7"));
                fullInputFu.setAnswer8a((String) entry.get("answer8A"));
                fullInputFu.setAnswer8b((String) entry.get("answer8B"));
                fullInputFu.setAnswer8c((String) entry.get("answer8C"));
                fullInputFu.setAnswer8d((String) entry.get("answer8D"));
                fullInputFu.setRight8((String) entry.get("right8"));
                fullInputFu.setAnswer9a((String) entry.get("answer9A"));
                fullInputFu.setAnswer9b((String) entry.get("answer9B"));
                fullInputFu.setAnswer9c((String) entry.get("answer9C"));
                fullInputFu.setAnswer9d((String)entry.get("answer9D"));
                fullInputFu.setRight9((String) entry.get("right9"));
                fullInputFu.setAnswer10a((String) entry.get("answer10A"));
                fullInputFu.setAnswer10b((String)entry.get("answer10B"));
                fullInputFu.setAnswer10c((String) entry.get("answer10C"));
                fullInputFu.setAnswer10d((String) entry.get("answer10D"));
                fullInputFu.setRight10((String) entry.get("right10"));
                fullInputFu.setAnswer11a((String) entry.get("answer11A"));
                fullInputFu.setAnswer11b((String) entry.get("answer11B"));
                fullInputFu.setAnswer11c((String) entry.get("answer11C"));
                fullInputFu.setAnswer11d((String) entry.get("answer11D"));
                fullInputFu.setRight11((String) entry.get("right11"));
                fullInputFu.setAnswer12a((String) entry.get("answer12A"));
                fullInputFu.setAnswer12b((String) entry.get("answer12B"));
                fullInputFu.setAnswer12c((String)entry.get("answer12C"));
                fullInputFu.setAnswer12d((String) entry.get("answer12D"));
                fullInputFu.setRight12((String) entry.get("right12"));
                fullInputFu.setAnswer13a((String)entry.get("answer13A"));
                fullInputFu.setAnswer13b((String) entry.get("answer13B"));
                fullInputFu.setAnswer13c((String)entry.get("answer13C"));
                fullInputFu.setAnswer13d((String)entry.get("answer13D"));
                fullInputFu.setRight13((String) entry.get("right13"));
                fullInputFu.setAnswer14a((String)entry.get("answer14A"));
                fullInputFu.setAnswer14b((String)entry.get("answer14B"));
                fullInputFu.setAnswer14c((String) entry.get("answer14C"));
                fullInputFu.setAnswer14d((String) entry.get("answer14D"));
                fullInputFu.setRight14((String) entry.get("right14"));
                fullInputFu.setAnswer15a((String) entry.get("answer15A"));
                fullInputFu.setAnswer15b((String) entry.get("answer15B"));
                fullInputFu.setAnswer15c((String) entry.get("answer15C"));
                fullInputFu.setAnswer15d((String)entry.get("answer15D"));
                fullInputFu.setRight15((String) entry.get("right15"));
                fullInputMapper.insert(fullInputFu);
                Exid=fullInputFu.getId();
            }
            recording.setExId(Exid);
            recording.setType(type);
            recording.setPaperId(paper.getId());
            recording.setState(1);
            recording.setExLevel(ex_level);
         //   recording.setExId(Integer.parseInt((String) entry.get("ex_id")));
           // System.out.println(entry.get("type"));
           // System.out.println(entry.get("paper_id"));
         //   System.out.println(entry.get("ex_id"));
            result=recordingMapper.insert(recording);
        }

        if(result>0)
        {
            return  CommonResult.success(paper.getId(),"创建试卷成功");
        }
            return CommonResult.success("组卷失败");
        }


    /**
     * 在题库中根据选题
     * @param type
     * @param subject
     * @return
     */
    @Override
    public CommonResult<List> getTopic(int type, String subject,String level) {
        //单选
        if (type==1)
        {
            QueryWrapper<Choose> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("ct_subject",subject);
            queryWrapper.eq("ct_state",1);
            queryWrapper.eq("ct_level",level);
            List<Choose> list = chooseMapper.selectList(queryWrapper);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看单选题目成功");
        }
        //多选
        else if(type==2)
        {
            QueryWrapper<Choose> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("ct_subject",subject);
            queryWrapper.eq("ct_state",2);
            queryWrapper.eq("ct_level",level);
            List<Choose> list =chooseMapper.selectList(queryWrapper);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看多选题目成功");
        }
        //填空
        else if(type==3)
        {
            QueryWrapper<Fill> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("ft_subject",subject);
            queryWrapper.eq("ft_state",1);
            queryWrapper.eq("ft_level",level);
            List<Fill> list =fillMapper.selectList(queryWrapper);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看填空题目成功");
        }
        //判断
        else if(type==4)
        {
            QueryWrapper<Fill> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("ft_subject",subject);
            queryWrapper.eq("ft_state",2);
            queryWrapper.eq("ft_level",level);
            List<Fill> list =fillMapper.selectList(queryWrapper);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //阅读理解
        else if(type==5)
        {
            QueryWrapper<Yue> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("yue_subject",subject);
            queryWrapper.eq("yue_level",level);
            List<Yue> list =yueMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //分录
        else if(type==6)
        {
            QueryWrapper<Fen> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("fen_subject",subject);
            queryWrapper.eq("fen_level",level);
            queryWrapper.eq("f_state",1);
            List<Fen> list =fenMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //阅读理解
        else if(type==7)
        {
            QueryWrapper<Fen> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("fen_subject",subject);
            queryWrapper.eq("fen_level",level);
            queryWrapper.eq("f_state",2);
            List<Fen> list =fenMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //名词解析
        else if(type==8)
        {
            QueryWrapper<Mingci> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("mt_subject",subject);
            queryWrapper.eq("mt_level",level);
            queryWrapper.eq("mt_state",1);
            List<Mingci> list =mingciMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //论述
        else if(type==9)
        {
            QueryWrapper<Mingci> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("mt_subject",subject);
            queryWrapper.eq("mt_level",level);
            queryWrapper.eq("mt_state",2);
            List<Mingci> list =mingciMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //.计算题
        else if(type==10)
        {
            QueryWrapper<Mingci> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("mt_subject",subject);
            queryWrapper.eq("mt_level",level);
            queryWrapper.eq("mt_state",3);
            List<Mingci> list =mingciMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //简答
        else if(type==11)
        {
            QueryWrapper<Mingci> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("mt_subject",subject);
            queryWrapper.eq("mt_level",level);
            queryWrapper.eq("mt_state",4);
            List<Mingci> list =mingciMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //口语
        else if(type==12)
        {
            QueryWrapper<Mingci> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("mt_subject",subject);
            queryWrapper.eq("mt_level",level);
            queryWrapper.eq("mt_state",5);
            List<Mingci> list =mingciMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //完型
        else if(type==13)
        {
            QueryWrapper<FullInput> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("fut_subject",subject);
            queryWrapper.eq("fut_level",level);
            List<FullInput> list =fullInputMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
        //听力
        else if(type==14)
        {
            QueryWrapper<Listen> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("lt_subject",subject);
            queryWrapper.eq("lt_level",level);
            List<Listen> list =listenMapper.selectList(queryWrapper);
            System.out.println(list);
            if (list.isEmpty())
                return CommonResult.failed("题库为空");
            return CommonResult.success(list,"查看判断题目成功");
        }
            return CommonResult.failed("返回失败");
    }




    /**
     * 查看试卷
     * @param paper_id
     * @return
     */
    @Override  // 1
    public CommonResult <List>viewPaper(int paper_id)
    {
        QueryWrapper<Recording> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("paper_id",paper_id);
        List<Recording> list =recordingMapper.selectList(queryWrapper);
        //类型和题号
        System.out.println(list.size());
        //   List<Object> ReturnList = null;
       List ReturnList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
           // Object lo = list.get(i);
            System.out.println(list.get(i).getExLevel()+"---"+list.get(i).getType()+"---"+list.get(i).getExId());
            int type=list.get(i).getType();
            int id=list.get(i).getExId();
            System.out.println(type+"---"+id);
            //无论单选 多选 是根据 唯一的题号  1
            if (type==1||type==2)
            {
                System.out.println("aaa");
                QueryWrapper<Choose> queryWrapper1 = new QueryWrapper<>();
                queryWrapper1.eq("id",id);
               // Object lo = chooseFuMapper.selectList(queryWrapper1);
              //  System.out.println(lo);
                ReturnList.add(chooseMapper.selectList(queryWrapper1));
                continue;
            }
            //填空
            else if(type==3)
            {
                QueryWrapper<Fill> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("id",id);
            //    Object lo =fillFuMapper.selectList(queryWrappe.r1);
              //  System.out.println(lo);
                ReturnList.add(fillMapper.selectList(queryWrapper1));
                continue;
            }
            //判断  1
            else if(type==4)
            {
                QueryWrapper<Fill> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("id",id);
            //    Object lo =fillFuMapper.selectList(queryWrapper1);
            //    System.out.println(lo);
                ReturnList.add(fillMapper.selectList(queryWrapper1));
                continue;
            }
            //阅读理解  1
            else if(type==5)
            {
                QueryWrapper<Yue> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("id",id);
             //   Object lo =yueFuMapper.selectList(queryWrapper1);
               // System.out.println(lo);
                ReturnList.add(yueMapper.selectList(queryWrapper1));
                continue;
            }

            //分录资料  1
            else if(type==6||type==7)
            {
                QueryWrapper<Fen> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("id",id);
                ReturnList.add(fenMapper.selectList(queryWrapper1));
                continue;
            }

            //8.名词解析 9.论述  10.计算题  11.简答 12.口语  1
            else if(type==8||type==9||type==10||type==11||type==12)
            {
                QueryWrapper<Mingci> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("id",id);
                ReturnList.add(mingciMapper.selectList(queryWrapper1));
                continue;
            }

           // 13.完型  1
            else if(type==13)
            {
                QueryWrapper<FullInput> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("id",id);
                //   Object lo =yueFuMapper.selectList(queryWrapper1);
                // System.out.println(lo);
                ReturnList.add(fullInputMapper.selectList(queryWrapper1));
                continue;
            }

          //  14.听力  1
            else if(type==14)
            {
                QueryWrapper<Listen> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("id",id);
                //   Object lo =yueFuMapper.selectList(queryWrapper1);
                // System.out.println(lo);
                ReturnList.add(listenMapper.selectList(queryWrapper1));
                continue;
            }
        }
      //  System.out.println(ReturnList);
    /*    Map map=(Map) list;
        System.out.println(map.get("type")+"----"+map.get("exId"));*/
        return CommonResult.success(ReturnList,"查看判断题目成功");
    }


    /**
     * 随机组卷
     * @param map
     * @return
     */
    @Override
    public CommonResult<List> randomPaper(Map map) {
       // System.out.println(map.get("topic"));
        List<String> list = (List) map.get("topic");
        List ReturnList = new ArrayList<>();
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Object lo = list.get(i);
            Map entry = (Map) lo;
            int type=Integer.parseInt((String) entry.get("type"));
            int num=Integer.parseInt((String) entry.get("num"));
            System.out.println(type+" "+num);
            if (type==1||type==2) //单选
            {
                QueryWrapper<Choose> queryWrapper1 = new QueryWrapper<>();
                if (type==1)
                queryWrapper1.eq("ct_state", 1);
                else if (type==2)
                    queryWrapper1.eq("ct_state", 2);
                //获取符合的集合
                List a = chooseMapper.selectList(queryWrapper1);
              //  System.out.println("------------" + a.size());
                if (a.size()<num)    return CommonResult.failed("单选出题数量大于题库所有");
                Random r = new Random();
                List mylist = new ArrayList();
                //生成随机数
                 while (true)
                 {
                    int rand = r.nextInt(a.size());
                    if (!mylist.contains(rand)) {
                        mylist.add(rand);
                    }
                    if (mylist.size()>=num) break;
                }
                for (int j = 0; j < mylist.size(); j++) {
                    ReturnList.add(a.get((Integer) mylist.get(j)));
                }
                continue;
            }
            //填空 判断
            else if(type==3||type==4)
            {
                QueryWrapper<Fill> queryWrapper1 = new QueryWrapper<>();
                if (type==3) queryWrapper1.eq("ft_state", 1);
                else if (type==4)
                queryWrapper1.eq("ft_state", 2);
                List a = fillMapper.selectList(queryWrapper1);
                if (a.size()<num)    return CommonResult.failed("填空判断出题数量大于题库所有");
                System.out.println(a);
                Random r = new Random();
                List mylist = new ArrayList();
                while (true)
                {
                    int rand = r.nextInt(a.size());
                    if (!mylist.contains(rand)) {
                        mylist.add(rand);
                    }
                    if (mylist.size()>=num) break;
                }
                for (int j = 0; j < mylist.size(); j++) {
                    ReturnList.add(a.get((Integer) mylist.get(j)));
                }
                continue;
            }
            //阅读理解
            else if(type==5)
            {
                QueryWrapper<Yue> queryWrapper1=new QueryWrapper<>();
               // System.out.println(yueMapper.selectList(queryWrapper1).size());
                int size=yueMapper.selectList(queryWrapper1).size();
                if (size<num)    return CommonResult.failed("阅读理解出题数量大于题库所有");
                Random r = new Random();
                List mylist = new ArrayList();
                while (true)
                {
                    int rand = r.nextInt(size);
                    if (!mylist.contains(rand)) {
                        mylist.add(rand);
                    }
                    if (mylist.size()>=num) break;
                }
                System.out.println(mylist);
                for (int j = 0; j < mylist.size(); j++) {
                    QueryWrapper<Yue> queryWrapper2=new QueryWrapper<>();
                    queryWrapper2.eq("id",(Integer) mylist.get(j)+1);
                    List a = yueMapper.selectList(queryWrapper2);
                    System.out.println(a);
                    ReturnList.add(a);
                }
                continue;
            }
            //分录 资料
            else if(type==6||type==7)
            {
                QueryWrapper<Fen> queryWrapper1 = new QueryWrapper<>();
                if (type==6) queryWrapper1.eq("f_state", 1);
                else if  (type==7)queryWrapper1.eq("f_state", 2);
                List a = fenMapper.selectList(queryWrapper1);
                if (a.size()<num)    return CommonResult.failed("分录 资料出题数量大于题库所有");
                System.out.println(a);
                Random r = new Random();
                List mylist = new ArrayList();
                while (true)
                {
                    int rand = r.nextInt(a.size());
                    if (!mylist.contains(rand)) {
                        mylist.add(rand);
                    }
                    if (mylist.size()>=num) break;
                }
                for (int j = 0; j < mylist.size(); j++) {
                    ReturnList.add(a.get((Integer) mylist.get(j)));
                }
                continue;
            }
           //1名词解析 2论述 3.计算题 4.简答 5.口语
            else if(type==8||type==9||type==10||type==11||type==12)
            {
                QueryWrapper<Mingci> queryWrapper1 = new QueryWrapper<>();
                if (type==8) queryWrapper1.eq("mt_state", 1);
               else if (type==9) queryWrapper1.eq("mt_state", 2);
                else if (type==10) queryWrapper1.eq("mt_state", 3);
                else if (type==11) queryWrapper1.eq("mt_state", 4);
                else if (type==12)    queryWrapper1.eq("mt_state", 5);
                List a = mingciMapper.selectList(queryWrapper1);
                if (a.size()<num)    return CommonResult.failed("1名词解析 2论述 3.计算题 4.简答 5.口语题数量大于题库所有");
                System.out.println(a);
                Random r = new Random();
                List mylist = new ArrayList();
                while (true)
                {
                    int rand = r.nextInt(a.size());
                    if (!mylist.contains(rand)) {
                        mylist.add(rand);
                    }
                    if (mylist.size()>=num) break;
                }
                for (int j = 0; j < mylist.size(); j++) {
                    ReturnList.add(a.get((Integer) mylist.get(j)));
                }
                continue;
            }
            //完型
            else if(type==13)
            {
                QueryWrapper<FullInput> queryWrapper1=new QueryWrapper<>();
                // System.out.println(yueMapper.selectList(queryWrapper1).size());
                int size=fullInputMapper.selectList(queryWrapper1).size();
                if (size<num)    return CommonResult.failed("完型出题数量大于题库所有");
                Random r = new Random();
                List mylist = new ArrayList();
                while (true)
                {
                    int rand = r.nextInt(size);
                    if (!mylist.contains(rand)) {
                        mylist.add(rand);
                    }
                    if (mylist.size()>=num) break;
                }
                System.out.println(mylist);
                for (int j = 0; j < mylist.size(); j++) {
                    QueryWrapper<FullInput> queryWrapper2=new QueryWrapper<>();
                    queryWrapper2.eq("id",(Integer) mylist.get(j)+1);
                    List a = fullInputMapper.selectList(queryWrapper2);
                    System.out.println(a);
                    ReturnList.add(a);
                }
                continue;
            }
            //听力
            else if(type==14)
            {
                QueryWrapper<Listen> queryWrapper1=new QueryWrapper<>();
                // System.out.println(yueMapper.selectList(queryWrapper1).size());
                int size=listenMapper.selectList(queryWrapper1).size();
                if (size<num)    return CommonResult.failed("听力出题数量大于题库所有");
                Random r = new Random();
                List mylist = new ArrayList();
                while (true)
                {
                    int rand = r.nextInt(size);
                    if (!mylist.contains(rand)) {
                        mylist.add(rand);
                    }
                    if (mylist.size()>=num) break;
                }
                System.out.println(mylist);
                for (int j = 0; j < mylist.size(); j++) {
                    QueryWrapper<Listen> queryWrapper2=new QueryWrapper<>();
                    queryWrapper2.eq("id",(Integer) mylist.get(j)+1);
                    List a = listenMapper.selectList(queryWrapper2);
                    System.out.println(a);
                    ReturnList.add(a);
                }
                continue;
            }




        }
        return CommonResult.success(ReturnList,"成功");
    }



    //题库添加题
    @Override
    public CommonResult addTopic(int type) {
        //单选 ,多选
        if (type==1||type==2)
          {
              QueryWrapper<ChooseFu> queryWrapper1 = new QueryWrapper<>();
              //获取符合的集合
              List a = chooseFuMapper.selectList(queryWrapper1);
          }
        //判断填空
        else if(type==3||type==5){
        }
        return CommonResult.success("成功");
    }

    //删除试卷
    @Override
    public CommonResult   deletePaper(int paper_id) {
        //试卷记录表 删除
            QueryWrapper<Recording> queryWrapper1 = new QueryWrapper<>();
        //试卷表删除
            QueryWrapper<Paper> queryWrapper2 = new QueryWrapper<>();
            Recording recording =new Recording();
            Paper paper =new Paper();
            recording.setState(0);
            paper.setStateDe(0);
            queryWrapper1.eq("paper_id",paper_id);
            queryWrapper2.eq("id",paper_id);
             int result1=recordingMapper.update(recording,queryWrapper1);
             int result2=paperMapper.update(paper,queryWrapper2);
             if (result1>=1&&result2>=1)    return CommonResult.success(result2,"成功");
        return CommonResult.failed("试卷编号不存在或者已被删除");
    }



    //创建考试
    @SneakyThrows
    @Override
    public CommonResult createExam(Map map) {
        int paper_id=Integer.parseInt((String) map.get("paper_id"));
        Paper paper = new Paper();
        paper.setExamName((String) map.get("exam_name"));
        paper.setManner("抽题");
        paper.setTeaName((String) map.get("tea_name"));
        paper.setExamTime((String) map.get("exam_time"));

        //把string转 Date Date转localdatetime
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ZoneId zoneId = ZoneId.systemDefault();
          Date a=format.parse((String) map.get("start_time"));
          Date b=format.parse((String) map.get("start_time"));
          LocalDateTime localDateTimea= LocalDateTime.ofInstant(a.toInstant(),zoneId);
          LocalDateTime localDateTimeb= LocalDateTime.ofInstant(b.toInstant(),zoneId);
          paper.setStartTime(localDateTimea);
          paper.setEndTime(localDateTimeb);

          //统计考试班级
        List list= (List) map.get("ks_class_paper");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            ClassPaper classPaper=new ClassPaper();
            classPaper.setPaperId(paper_id);
            classPaper.setSpecialized((String) list.get(i));
            String specialized= (String) list.get(i);

            System.out.println(specialized);
            QueryWrapper<Class> queryWrapper6 = new QueryWrapper<>();
            queryWrapper6.eq("specialized",specialized);
            list =  classMapper.selectList(queryWrapper6);
            System.out.println(list);


          //  Class class1=new Class();
            //class1= classMapper.selectOne(queryWrapper);
           // System.out.println(classMapper.selectOne(queryWrapper6));

        //    System.out.println("------------"+class1);
          //  System.out.println("****************************************************************");
         //   System.out.println((classMapper.selectOne(queryWrapper6)).getSchool_cl());
         //   System.out.println(class1.getSchool_cl());

            //输出学校id
        /*   Integer Schoolid=class1.getSchool_cl();
            System.out.println("----------------------"+Schoolid+"------------------");*/

/*
          QueryWrapper<School> queryWrapper2=new QueryWrapper<>();
             School school=schoolMapper.selectOne(queryWrapper2.eq("id",Schoolid));
           classPaper.setSch_paper(school.getName());
           classPaperMapper.insert(classPaper);
            System.out.println(list.get(i));
*/
        }
        QueryWrapper<Paper> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("id",paper_id);
        paper.setState(0);
        int result=paperMapper.update(paper,queryWrapper1);
        System.out.println(result);
        if(result>=1)
        return CommonResult.success("创建考试成功");
        return CommonResult.failed("创建考试失败");
    }

    @Override
    public CommonResult test(String aa) {
      //  QueryWrapper<Class> queryWrapper6 = new QueryWrapper<>();
        QueryWrapper<ClassPaper> queryWrapper= new QueryWrapper<>();
      //  queryWrapper6.eq("specialized",aa);
        queryWrapper.eq("specialized",aa);
        //  classMapper.selectOne(queryWrapper6);
       // System.out.println(clas            sMapper.selectOne(queryWrapper6));
        System.out.println(classPaperMapper.selectOne(queryWrapper));
        return CommonResult.success("测试成功");
    }

}

