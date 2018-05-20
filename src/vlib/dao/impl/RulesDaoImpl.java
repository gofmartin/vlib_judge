package vlib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vlib.dao.RulesDao;
import vlib.entity.JudgeDetail;
import vlib.judger.JavaJudger;
import vlib.util.DBUtils;

public class RulesDaoImpl implements RulesDao {
	
	private static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // 读取指定的主配置文件
        sessionFactory = cfg.buildSessionFactory(); // 根据配置生成Session工厂
    }

	@Override
	public void add(JudgeDetail judgeDetail) {
		Session session = sessionFactory.openSession(); // 打开一个新的Session
        Transaction tx = session.beginTransaction(); // 开启事务
        
        session.save(judgeDetail);
        System.out.println("added");
        
        tx.commit(); // 提交事务
        session.close(); // 关闭Session，释放资源(不一定是真正的关闭)
	}

	@Override
	public void edit(JudgeDetail judgeDetail) {
		Session session = sessionFactory.openSession(); // 打开一个新的Session
        Transaction tx = session.beginTransaction(); // 开启事务
        
        session.update(judgeDetail);
        
        tx.commit();
        session.close();
	}

	@Override
	public JudgeDetail read(int expId) {
		Session session = sessionFactory.openSession(); // 打开一个新的Session
        Transaction tx = session.beginTransaction(); // 开启事务
        
        String hql = "from JudgeDetail where expid=?";
        JudgeDetail judgeDetail = (JudgeDetail) session.createQuery(hql).setParameter(0, expId).uniqueResult();
        judgeDetail = (JudgeDetail) session.load(JudgeDetail.class, judgeDetail.getId());
        JavaJudger javaJudger = new JavaJudger();
        javaJudger.GetTotalScore(judgeDetail);
        
        tx.commit();
        session.close();
        
		return judgeDetail;
	}

}
