package cc.ccbang.base.mybatis.interceptor;

import java.sql.Connection;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;

import cc.ccbang.base.utils.Pagination;


@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }))
public class PaginationInterceptor implements Interceptor {
	
	private final static String SQL_SELECT_REGEX = "(?is)^\\s*SELECT.*$";
    private final static String SQL_COUNT_REGEX = "(?is)^\\s*SELECT\\s+COUNT\\s*\\(\\s*(?:\\*|\\w+)\\s*\\).*$";

	@Override
	public Object intercept(Invocation inv) throws Throwable {
		StatementHandler target = (StatementHandler) inv.getTarget();
        BoundSql boundSql = target.getBoundSql();
        String sql = boundSql.getSql();
        if (StringUtils.isBlank(sql)) {
            return inv.proceed();
        }
        System.out.println("origin sql>>>>>" + sql.replaceAll("\n", ""));
        // 只有为select查询语句时才进行下一步
        if (sql.matches(SQL_SELECT_REGEX)
                && !Pattern.matches(SQL_COUNT_REGEX, sql)) {
        	Object obj = FieldUtils.readField(target, "delegate", true);
        	
        	
        	/*
            // 反射获取 RowBounds 对象。
            RowBounds rowBounds = (RowBounds) FieldUtils.readField(obj,
                    "rowBounds", true);
            
            // 分页参数存在且不为默认值时进行分页SQL构造
            if (rowBounds != null && rowBounds != RowBounds.DEFAULT) {
                FieldUtils.writeField(boundSql, "sql", newMySqlQuery(sql, rowBounds),
                        true);
                System.out.println("new sql>>>>>"
                        + boundSql.getSql().replaceAll("\n", ""));
                // 一定要还原否则将无法得到下一组数据(第一次的数据被缓存了)
                FieldUtils.writeField(rowBounds, "offset",
                        RowBounds.NO_ROW_OFFSET, true);
                FieldUtils.writeField(rowBounds, "limit",
                        RowBounds.NO_ROW_LIMIT, true);
            }
            */
            //reflect pagination
        	Pagination page = null;
        	
        	Object param = ((ParameterHandler) FieldUtils.readField(obj, "parameterHandler", true)).getParameterObject();
        	if(param instanceof ParamMap){
        		
        		ParamMap paramMap = (ParamMap)param;
        		page = (Pagination) paramMap.get(Pagination.PAGINATION_PARAM_KEY);
        		if(page == null){
        			return inv.proceed();
        		}
        		
        	}else if(param instanceof ParamMap){
        		page = (Pagination) param;
        	}else{
        		return inv.proceed();
        	}
        	
            if(page != null && page != Pagination.DEFAULT){
            	FieldUtils.writeField(boundSql, "sql", newMySqlQuery(sql, page),
                        true);
            	System.out.println("new sql>>>>>"
                        + boundSql.getSql().replaceAll("\n", ""));
            	
            	// 一定要还原否则将无法得到下一组数据(第一次的数据被缓存了)
//                FieldUtils.writeField(page, "start",
//                        Pagination.START_0, true);
//                FieldUtils.writeField(page, "length",
//                		Pagination.LENGTH_0, true);
            }
        }
        return inv.proceed();
	}
	
	public String newMySqlQuery(String oldSql, Pagination page) {
//        String start = " SELECT * FROM   (SELECT   row_.*, ROWNUM rownum_ FROM ( ";
//        String end = " ) row_ WHERE   ROWNUM <= " + rowBounds.getLimit()
//                + ") WHERE   rownum_ > " + rowBounds.getOffset();
//        return start + oldSql + end;
        
        return oldSql + " limit " + page.getStart() + " , " + page.getLength();
        
    }

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		System.out.println(arg0);
	}
	
}
