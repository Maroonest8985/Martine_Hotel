package com.example.demo.repository;
import com.example.demo.model.MemberDTO;
import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.RoomsDTO;
import com.example.demo.repository.MemberDAO;
import com.example.demo.Pagination;

import java.lang.reflect.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl extends DAOImplMysql implements MemberDAO {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public MemberDAOImpl() {
        conn = getConn();
    }

    @Override
    public int insertMember(MemberDTO memberDTO) {
        try {
            String sqlQuery = "INSERT INTO `member`(`name`, `id`, `pwd`, `rank`, `tel`, `email`) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, memberDTO.getName());
            pstmt.setString(2, memberDTO.getId());
            pstmt.setString(3, memberDTO.getPwd());
            pstmt.setInt(4, memberDTO.getRank());
            pstmt.setString(5, memberDTO.getTel());
            pstmt.setString(6, memberDTO.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public int checkMember(String user) {
        try {
            String sqlQuery = "SELECT * FROM member WHERE id = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, user);
            rs = pstmt.executeQuery();
            if (rs.next() || user.equals("")) {// 결과값과 checkMember의 인자가 동일하면
                return 0; // 일치하는 id가 있으면 0 리턴
            } else {
                return 1; // 일치하는 id가 없으면 1 리턴
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;// db에러일때 -1리턴
    }

    public int memberLogin(String id, String pwd) {
        try {
            String sqlQuery = "SELECT pwd From member WHERE id = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString(1).equals(pwd)) {
                    return 1; // 로그인 성공
                } else {
                    return 0;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return 0;
    }
    public List<MemberDTO> memberList() {
        String sqlQuery = "SELECT * FROM member";
        ArrayList<MemberDTO> memberList = null;
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            memberList = new ArrayList<MemberDTO>();
            while (rs.next()) {
                MemberDTO member = new MemberDTO(); // roomlist->방 리스트 저장공간
                member.setNo(rs.getInt("no"));
                member.setName(rs.getString("name"));
                member.setId(rs.getString("id"));
                member.setPwd(rs.getString("pwd"));
                member.setRank(rs.getInt("rank"));
                member.setTel(rs.getString("tel"));
                member.setEmail(rs.getString("email"));
                memberList.add(member);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return memberList;
    }

    @Override
    public int readTotalRows() {
        int rows = 0;
        String sqlQuery = "select count(*) as totalRows from member";
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            // execute(sql)는 모든 질의에 사용가능, executeQuery(sql)는 select에만, executeUpdate()는 insert, update, delete에 사용 가능
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rows = rs.getInt("totalRows");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<MemberDTO> readListPagination(Pagination pagination) {
        ArrayList<MemberDTO> memberList  = null;
        String sqlQuery = "SELECT * FROM (SELECT @rownum:=@rownum+1 as rnum, A.* FROM member A WHERE (@rownum:=0)=0 order by no)rd where rnum >= ? and rnum <= ?;";
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, pagination.getFirstRow());
            pstmt.setInt(2, pagination.getEndRow());
            rs = pstmt.executeQuery();
            // execute(sql)는 모든 질의에 사용가능, executeQuery(sql)는 select에만, executeUpdate()는 insert, update, delete에 사용 가능
            memberList = new ArrayList<MemberDTO>();
            while (rs.next()) {
                MemberDTO member = new MemberDTO(); // roomlist->방 리스트 저장공간
                member.setNo(rs.getInt("no"));
                member.setName(rs.getString("name"));
                member.setId(rs.getString("id"));
                member.setPwd(rs.getString("pwd"));
                member.setRank(rs.getInt("rank"));
                member.setTel(rs.getString("tel"));
                member.setEmail(rs.getString("email"));
                memberList.add(member);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return memberList;
    }
    @Override
    public int update(MemberDTO memberDTO){
        String sqlQuery ="UPDATE member SET `name`=?,`id`=?,`pwd`=?,`rank`=?,`tel`=?,`email`=? WHERE no=?";
        int rows=0;
        try{
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, memberDTO.getName());
            pstmt.setString(2, memberDTO.getId());
            pstmt.setString(3, memberDTO.getPwd());
            pstmt.setInt(4, memberDTO.getRank());
            pstmt.setString(5, memberDTO.getTel());
            pstmt.setString(6, memberDTO.getEmail());
            pstmt.setInt(7, memberDTO.getNo());
            rows = pstmt.executeUpdate();//1이상이면 정상 ,0이하면 오류
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
    @Override
    public int delete(MemberDTO memberDTO) {
        String sql = "delete from member where no=?";
        int rows = 0; //질의 처리 결과 영향받은 행의 수
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberDTO.getNo());
            rows = pstmt.executeUpdate();//1이상이면 정상 ,0이하면 오류
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
    @Override
    public MemberDTO readMemberList(int no) {
        MemberDTO memberList = null;
        try {
            String sqlQuery = "SELECT * FROM member WHERE no = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            memberList = new MemberDTO();
            while (rs.next()) {
                memberList.setNo(rs.getInt("no"));
                memberList.setName(rs.getString("name"));
                memberList.setId(rs.getString("id"));
                memberList.setPwd(rs.getString("pwd"));
                memberList.setRank(rs.getInt("rank"));
                memberList.setTel(rs.getString("tel"));
                memberList.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }

    @Override
    public MemberDTO readMemberListAsId(String id) {
        MemberDTO memberList = null;
        try {
            String sqlQuery = "SELECT * FROM member WHERE id = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            memberList = new MemberDTO();
            while (rs.next()) {
                memberList.setNo(rs.getInt("no"));
                memberList.setName(rs.getString("name"));
                memberList.setId(rs.getString("id"));
                memberList.setPwd(rs.getString("pwd"));
                memberList.setRank(rs.getInt("rank"));
                memberList.setTel(rs.getString("tel"));
                memberList.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }

}
