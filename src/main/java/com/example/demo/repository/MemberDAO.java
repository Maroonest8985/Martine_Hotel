package com.example.demo.repository;
import com.example.demo.model.MemberDTO;
import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.RoomsDTO;
import com.example.demo.Pagination;

import java.lang.reflect.Member;
import java.util.List;

public interface MemberDAO {
    int insertMember(MemberDTO memberDTO);
    int checkMember(String user);
    int memberLogin(String id , String pwd);
    List<MemberDTO> memberList();
    int readTotalRows();
    List<MemberDTO> readListPagination(Pagination pagination);
    int update(MemberDTO memberDTO);
    int delete(MemberDTO memberDTO);
    MemberDTO readMemberList(int no);
    MemberDTO readMemberListAsId(String id);
}
