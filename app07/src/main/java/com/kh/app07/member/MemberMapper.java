package com.kh.app07.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {
    @Insert("""
            INSERT INTO MEMBER
            (
                NO
                ,USER_ID
                ,USER_PWD
                ,USER_NICK
            )
            VALUES
            (
                SEQ_MEMBER.NEXTVAL
                , #{userId}
                , #{userPwd}
                , #{userNick}
            )
            """)
    int join(MemberVo vo);

    @Select("""
            SELECT
                NO
                ,USER_ID
                ,USER_PWD
                ,USER_NICK
                ,CREATED_DATE
                ,DEL_YN
            FROM MEMBER
            WHERE USER_ID = #{userId}
            AND USER_PWD = #{userPwd}
            AND DEL_YN = 'N'
            """)
    MemberVo login(MemberVo vo);


    @Update("""
            UPDATE MEMBER
                SET
                    DEL_YN = 'Y'
                WHERE USER_ID = #{userId}
                AND USER_PWD = #{userPwd}
            """

    )
    int quit(MemberVo loginMember);


    @Update("""
            
            """)
    int update(MemberVo vo);
}

