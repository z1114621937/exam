package com.manages.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.api.CommonResult;
import com.manages.service.*;
import com.mbg.exam.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/manages")
public class ManagesController {


    @Autowired
    TikuImplService tikuImplService;

    @Autowired
    KuImplService kuImplService;

    @Autowired
    StudentImplService studentImplService;

    @Autowired
    ChooseImplService chooseImplService;

    @Autowired
    FenImplService fenImplService;

    @Autowired
    FillImplService fillImplService;

    @Autowired
    FullInputImplService fullInputImplService;

    @Autowired
    ListenImplService listenImplService;

    @Autowired
    MingciImplService mingciImplService;

    @Autowired
    YueImplService yueImplService;

    @Autowired
    LogUnImplService logUnImplService;

    /**
     * 添加题库
     * @param id
     * @param name
     * @param subject
     * @return
     */
    @RequestMapping("/addku")
    public CommonResult addku(@RequestHeader("memberId") Integer id, @RequestParam String name,
                                  @RequestParam String subject) {
        Student student=studentImplService.getById(id);

        System.out.println(student);

        return tikuImplService.addku(name,subject,student.getName());
    }

    @RequestMapping("/addch")
    public CommonResult addch(@RequestBody Choose choose,@RequestParam Integer id) {
        System.out.println(choose);

        chooseImplService.save(choose);

        Ku ku=new Ku();
        ku.setChId(choose.getId());
        ku.setTikuId(id);
        kuImplService.save(ku);
        return CommonResult.success(choose.getId(),"添加选择题成功");
    }

    @RequestMapping("/addfen")
    public CommonResult addfen(@RequestBody Fen fen,@RequestParam Integer id) {
        System.out.println(fen);

        fenImplService.save(fen);
        Ku ku=new Ku();
        ku.setFenId(fen.getId());
        ku.setTikuId(id);
        kuImplService.save(ku);
        return CommonResult.success(fen.getId(),"多问多答类题添加成功");
    }

    @RequestMapping("/addfill")
    public CommonResult addfill(@RequestBody Fill fill,@RequestParam Integer id) {

        fillImplService.save(fill);
        Ku ku=new Ku();
        ku.setFillId(fill.getId());
        ku.setTikuId(id);
        kuImplService.save(ku);

        return CommonResult.success("一问一答题添加成功");
    }
    @RequestMapping("/addfullInput")
    public CommonResult addfullInput(@RequestBody FullInput fullInput,@RequestParam Integer id) {
        fullInputImplService.save(fullInput);
        Ku ku=new Ku();
        ku.setFullId(fullInput.getId());
        ku.setTikuId(id);
        kuImplService.save(ku);
        return CommonResult.success("完型题添加成功");
    }

    @RequestMapping("/addlisten")
    public CommonResult addlisten(@RequestBody Listen listen,@RequestParam Integer id) {
        listenImplService.save(listen);
        Ku ku=new Ku();
        ku.setListenId(listen.getId());
        ku.setTikuId(id);
        kuImplService.save(ku);
        return CommonResult.success("听力题添加成功");
    }


    @RequestMapping("/addmingci")
    public CommonResult addmingci(@RequestBody Mingci mingci,@RequestParam Integer id) {
        mingciImplService.save(mingci);
        Ku ku=new Ku();
        ku.setMingci(mingci.getId());
        ku.setTikuId(id);
        kuImplService.save(ku);
        return CommonResult.success("名词填空题添加成功");
    }

    @RequestMapping("/addyue")
    public CommonResult addyue(@RequestBody Yue yue,@RequestParam Integer id) {
        yueImplService.save(yue);
        Ku ku=new Ku();
        ku.setYueId(yue.getId());
        ku.setTikuId(id);
        kuImplService.save(ku);
        return CommonResult.success("阅读理解题添加成功");
    }





    @RequestMapping("/updatech")
    public CommonResult updatech(@RequestBody Choose choose,@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        Choose choose1 = chooseImplService.getById(id);

        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getCId,id);//xadadasdas

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        if(choose1.getCtState()==1){
            logUn.setOperate("对单选题"+id+"修改");
        }else {
            logUn.setOperate("对多选题"+id+"修改");
        }

        logUn.setCId(id);
        logUn.setUpde(1);
        logUn.setUnId(1);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return chooseImplService.updatech(id,choose,mid,ip);
    }

    @RequestMapping("/updatefen")
    public CommonResult updatefen(@RequestBody Fen fen,@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getFId,id);//xadadasdas

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        if(fen.getFState()==1){
            logUn.setOperate("对分录题"+id+"修改");
        }else {
            logUn.setOperate("对资料题"+id+"修改");
        }
        logUn.setFId(id);
        logUn.setUpde(1);
        logUn.setUnId(2);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return fenImplService.updatefen(id,fen);
    }

    @RequestMapping("/updatefill")
    public CommonResult updatefill(@RequestBody Fill fill,@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        Fill fill1 = fillImplService.getById(id);

        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getFiId,id);//xadadasdas

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        if(fill1.getFtState()==1){
            logUn.setOperate("对填空题"+id+"修改");
        }else {
            logUn.setOperate("对判断题"+id+"修改");
        }
        logUn.setFiId(id);
        logUn.setUpde(1);
        logUn.setUnId(3);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);

        return fillImplService.updatefill(id,fill);
    }

    @RequestMapping("/updatefull")
    public CommonResult updatefull(@RequestBody FullInput fullInput,@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        FullInput fullInput1 = fullInputImplService.getById(id);
        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getFuId,id);

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        logUn.setOperate("对完型填空题"+id+"修改");
        logUn.setFuId(id);
        logUn.setUpde(1);
        logUn.setUnId(4);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);

        return fullInputImplService.updatefull(id,fullInput);
    }

    @RequestMapping("/updatelisten")
    public CommonResult updatelisten(@RequestBody Listen listen,@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {

        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getLisId,id);

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        logUn.setOperate("对听力题"+id+"修改");
        logUn.setLisId(id);
        logUn.setUpde(1);
        logUn.setUnId(5);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return listenImplService.updatelisten(id,listen);
    }

    @RequestMapping("/updateming")
    public CommonResult updateming(@RequestBody Mingci mingci,@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        Mingci mingci1 = mingciImplService.getById(id);


        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getMinId,id);

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        if(mingci1.getMtState()==1){
            logUn.setOperate("对名词解析题"+id+"修改");
        }
        else if(mingci1.getMtState()==2) {
            logUn.setOperate("对论述题"+id+"修改");
        }
        else if(mingci1.getMtState()==3) {
            logUn.setOperate("对计算题"+id+"修改");
        }
        else if(mingci1.getMtState()==4) {
            logUn.setOperate("对分录题"+id+"修改");
        }
        else if(mingci1.getMtState()==5) {
            logUn.setOperate("对资料题"+id+"修改");
        }
        else {
            logUn.setOperate("对程序题"+id+"修改");
        }
        logUn.setMinId(id);
        logUn.setUpde(1);
        logUn.setUnId(6);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return mingciImplService.updateming(id,mingci);
    }

    @RequestMapping("/updateyue")
    public CommonResult updateyue(@RequestBody Yue yue,@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getYuId,id);

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        logUn.setOperate("对阅读题"+id+"修改");
        logUn.setYuId(id);
        logUn.setUpde(1);
        logUn.setUnId(7);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return yueImplService.updateyue(id,yue);
    }


    @RequestMapping(value = "/delch",method = RequestMethod.POST)
    public CommonResult delch(@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        Choose choose1 = chooseImplService.getById(id);

        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getCId,id);

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        if(choose1.getCtState()==1){
            logUn.setOperate("对单选题"+id+"删除");
        }else {
            logUn.setOperate("对多选题"+id+"删除");
        }

        logUn.setCId(id);
        logUn.setUpde(0);
        logUn.setUnId(1);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return chooseImplService.delch(id);
    }

    @RequestMapping(value = "/delfen",method = RequestMethod.POST)
    public CommonResult delfen(@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getFId,id);//xadadasdas

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        logUn.setOperate("对一问多答题"+id+"删除");
        logUn.setFId(id);
        logUn.setUpde(0);
        logUn.setUnId(2);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return fenImplService.delfen(id);
    }

    @RequestMapping(value = "/delfill",method = RequestMethod.POST)
    public CommonResult delfill(@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        Fill fill1 = fillImplService.getById(id);

        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getFiId,id);//xadadasdas

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        if(fill1.getFtState()==1){
            logUn.setOperate("对填空题"+id+"删除");
        }else {
            logUn.setOperate("对判断题"+id+"删除");
        }
        logUn.setFiId(id);
        logUn.setUpde(0);
        logUn.setUnId(3);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return fillImplService.delfill(id);
    }

    @RequestMapping(value = "/delfull",method = RequestMethod.POST)
    public CommonResult delfull(@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getFuId,id);

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        logUn.setOperate("对完型填空题"+id+"删除");
        logUn.setFuId(id);
        logUn.setUpde(0);
        logUn.setUnId(4);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return fullInputImplService.delfull(id);
    }

    @RequestMapping(value = "/dellisten",method = RequestMethod.POST)
    public CommonResult dellisten(@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getLisId,id);

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        logUn.setOperate("对听力题"+id+"删除");
        logUn.setLisId(id);
        logUn.setUpde(0);
        logUn.setUnId(5);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return listenImplService.dellisten(id);
    }

    @RequestMapping(value = "/delming",method = RequestMethod.POST)
    public CommonResult delming(@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        Mingci mingci1 = mingciImplService.getById(id);


        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getMinId,id);

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        if(mingci1.getMtState()==1){
            logUn.setOperate("对名词解析题"+id+"删除");
        }
        else if(mingci1.getMtState()==2) {
            logUn.setOperate("对论述题"+id+"删除");
        }
        else if(mingci1.getMtState()==3) {
            logUn.setOperate("对计算题"+id+"删除");
        }
        else if(mingci1.getMtState()==4) {
            logUn.setOperate("对简答题"+id+"删除");
        }
        else if(mingci1.getMtState()==5) {
            logUn.setOperate("对口语题"+id+"删除");
        }
        else {
            logUn.setOperate("对程序题"+id+"删除");
        }
        logUn.setMinId(id);
        logUn.setUpde(0);
        logUn.setUnId(6);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return mingciImplService.delming(id);
    }

    @RequestMapping(value = "/delyue",method = RequestMethod.POST)
    public CommonResult delyue(@RequestParam Integer id,@RequestHeader("memberId") Integer mid,@RequestParam String ip) {
        UpdateWrapper<LogUn> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(LogUn::getYuId,id);

        LogUn logUn=new LogUn();
        logUn.setTeaIp(ip);
        logUn.setTeaId(mid);
        logUn.setOperate("对阅读题"+id+"删除");
        logUn.setYuId(id);
        logUn.setUpde(0);
        logUn.setUnId(7);
        logUnImplService.saveOrUpdate(logUn,updateWrapper);
        return yueImplService.delyue(id);
    }


    @RequestMapping(value = "/selectyue",method = RequestMethod.GET)
    public CommonResult selectku(@RequestParam Integer id) {

        return kuImplService.selectku(id);
    }

    @RequestMapping(value = "/selectlog",method = RequestMethod.GET)
    public CommonResult selectlog() {

        return logUnImplService.selectlog();
    }

    @RequestMapping(value = "/selectlogun",method = RequestMethod.GET)
    public CommonResult selectlogun(@RequestParam Integer id,@RequestParam Integer unid) {
        if(unid==1){
            return CommonResult.success(chooseImplService.getById(id),"查询选择题");
        }
        else if(unid==2){
            return CommonResult.success(fenImplService.getById(id));
        }
        else if(unid==3){
            return CommonResult.success(fillImplService.getById(id));
        }
        else if(unid==4){
            return CommonResult.success(fullInputImplService.getById(id));
        }
        else if(unid==5){
            return CommonResult.success(listenImplService.getById(id));
        }
        else if(unid==6){
            return CommonResult.success(mingciImplService.getById(id));
        }
        else {
            return CommonResult.success(yueImplService.getById(id));
        }


    }


    @RequestMapping(value = "/selectlogun2",method = RequestMethod.GET)
    public CommonResult selectlogun2(@RequestParam Integer id,@RequestParam Integer unid,@RequestParam Integer upde) {
        if(unid==1){
            return chooseImplService.selectch(id,upde);
        }
        else if(unid==2){
            return fenImplService.selectfen(id,upde);
        }
        else if(unid==3){
            return fillImplService.selectfill(id,upde);
        }
        else if(unid==4){
            return fullInputImplService.selectfull(id,upde);
        }
        else if(unid==5){
            return listenImplService.selectlisten(id,upde);
        }
        else if(unid==6){
            return mingciImplService.selectming(id,upde);
        }
        else {
            return yueImplService.selectyue(id,upde);
        }


    }

}
