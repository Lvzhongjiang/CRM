package com.hy.crm.sql;


public class ContractSql {
    public String selectFor(String forum, String keyword) {
        String sql = "SELECT f.forumId,f.motif,f.author,business,click,COUNT(r.replyId)c,r.replytime,f.status FROM forum_management f  INNER JOIN reply r ON f.forumId=r.forumId";
        StringBuffer buffer = new StringBuffer(sql);
        if (keyword != null && forum != null) {
            if (forum.equals("1")) {
                buffer.append(" and motif  ='" + keyword + "'");
            }
            if (forum.equals("2")) {
                buffer.append(" and author  ='" + keyword + "'");
            }
            if (forum.equals("3")) {
                buffer.append(" and label ='" + keyword + "'");
            }
            if (forum.equals("4")) {
                buffer.append(" and click  ='" + keyword + "'");
            }
            if (forum.equals("5")) {
                buffer.append(" and c ='" + keyword + "'");
            }
        }
        buffer.append(" GROUP BY r.forumId  ORDER BY f.status DESC,r.replytime DESC");
        return buffer.toString();
    }

    public String selectCont(String status,String heTong, String keyword) {
        String sql = "SELECT cm.contName,cm.contNum,cm.contMany,cm.contDate,SUM(ri.regMany)s,SUM(ia.inAmount)s1,cm.status  FROM  contract_management cm INNER JOIN register_income ri ON  cm.contId=ri.contId INNER JOIN invoice_application ia  ON cm.contId=ia.contId ";
        StringBuffer buffer = new StringBuffer(sql);
        if (keyword != null && heTong != null) {
            if (heTong.equals("1")) {
                buffer.append(" and cm.contName ='" + keyword + "' ");
            }
            if (heTong.equals("2")) {
                buffer.append(" and cm.contNum ='" + keyword + "' ");
            }
            if (heTong.equals("3")) {
                buffer.append(" and cm.coll_term ='" + keyword + "' ");
            }
            if (heTong.equals("4")) {
                buffer.append(" and cm.relat_per ='" + keyword + "' ");
            }
            if (heTong.equals("5")) {
                buffer.append(" and cm.contMany ='" + keyword + "' ");
            }
            if (heTong.equals("6")) {
                buffer.append(" and cm.contDate ='" + keyword + "' ");
            }
        }
        if(status != null){
            if (status.equals("1")) {
                buffer.append(" and commenDate < CURRENT_DATE  AND CURRENT_DATE < viability ");
            }
            if (status.equals("2")) {
                buffer.append(" and  viability < CURRENT_DATE");
            }
            if (status.equals("3")) {
                buffer.append(" and  STATUS='已撤除的合同'");
            }
            if (status.equals("4")) {
                buffer.append(" and  STATUS='被搁置的合同'");
            }
        }

        buffer.append(" GROUP BY contName ");
        return buffer.toString();
    }

    public String selectDateType() {
        String sql="";
        StringBuffer buffer = new StringBuffer(sql);

        return buffer.toString();
    }
}
