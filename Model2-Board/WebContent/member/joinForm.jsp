<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   <title> 회원가입 </title>
   <style type="text/css">

   input[type=text] 
   {
      size: 20;
   }
   </style>
</head>

<body>
   <form action = "./MemberJoinAction.me" accept-charset="utf-8" method = "post" onsubmit="return validate()">

   <table width = "650" height="300" border="1" style="border-collapse: collapse;" align="center">
      <tr>
         <td colspan="2" align="center" bgcolor="#AF9FEC"><b>회원 기본 정보</b></td>
      </tr>
      <tr>
         <td align="center" bgcolor="#BDBDBD" width="120"><b>아이디:</b></td>
         <td><input type="text" name="MEMBER_ID" minlength="4" maxlength="12" autocomplete="false">&nbsp;
         4~12자의 영문 대소문자와 숫자로만 입력</td>
      </tr>
      <tr>
         <td align="center" bgcolor="#BDBDBD"><b>비밀번호:</b></td>
         <td><input type="password" name="MEMBER_PW" minlength="4" maxlength="12" >&nbsp;
         4~12자의 영문 대소문자와 숫자로만 입력</td>
      </tr>
      <tr>
         <td align="center" bgcolor="#BDBDBD"><b>비밀번호확인:</b></td>
         <td><input type="password" name="MEMBER_PW2" minlength="4" maxlength="12"></td>
      </tr>
      <tr>
         <td align="center" bgcolor="#BDBDBD"><b>메일주소:</b></td>
         <td><input type="email" name="MEMBER_EMAIL" id = "e_mail">&nbsp;예) id@domain.com</td>
      </tr>
      <tr>
         <td align="center" bgcolor="#BDBDBD"><b>이름:</b></td>
         <td><input type="text" name="MEMBER_NAME" id = "my_name"></td>
      </tr>
      <tr>
         <td colspan="3" align="center" bgcolor="#AF9FEC"><b>개인 신상 정보</b></td>
      </tr>
      <tr>
         <!-- /////////////////////////// -->
         <td align="center" bgcolor="#BDBDBD"><b>주민등록번호:</b></td>
         <td><input type="text" name="MEMBER_SSN" id="my_ssn" minlength="13" maxlength="13">&nbsp;
         예) 1234561234567</td>
      </tr>
      <tr>
         <td align="center" bgcolor="#BDBDBD"><b>생일:</b></td>
         <td><input type="text" name="MEMBER_BIRTH" id = "my_birthday" size="5" minlength="4" maxlength="4">년
            <select name="SelectMonth" id="my_month">
               <OPTION>1</OPTION>
                 <OPTION>2</OPTION>
                 <OPTION>3</OPTION>
                 <OPTION>4</OPTION>
                 <OPTION>5</OPTION>
                 <OPTION>6</OPTION>
                 <OPTION>7</OPTION>
                 <OPTION>8</OPTION>
                 <OPTION>9</OPTION>
                 <OPTION>10</OPTION>
                 <OPTION>11</OPTION>
                 <OPTION>12</OPTION>
             </select>월

              <SELECT name="SelectDay" id="my_date">
                 <OPTION>1</OPTION>
                 <OPTION>2</OPTION>
                 <OPTION>3</OPTION>
                 <OPTION>4</OPTION>
                 <OPTION>5</OPTION>
                 <OPTION>6</OPTION>
                 <OPTION>7</OPTION>
                 <OPTION>8</OPTION>
                 <OPTION>9</OPTION>
                 <OPTION>10</OPTION>
                 <OPTION>11</OPTION>
                 <OPTION>12</OPTION>
                 <OPTION>13</OPTION>
                 <OPTION>14</OPTION>
                 <OPTION>15</OPTION>
                 <OPTION>16</OPTION>
                 <OPTION>17</OPTION>
                 <OPTION>18</OPTION>
                 <OPTION>19</OPTION>
                 <OPTION>20</OPTION>
                 <OPTION>21</OPTION>
                 <OPTION>22</OPTION>
                 <OPTION>23</OPTION>
                 <OPTION>24</OPTION>
                 <OPTION>25</OPTION>
                 <OPTION>26</OPTION>
                 <OPTION>27</OPTION>
                 <OPTION>28</OPTION>
                 <OPTION>29</OPTION>
                 <OPTION>30</OPTION>
                 <OPTION>31</OPTION>
              </select>일
            </td>
      </tr>

      <tr>
         <td align="center" bgcolor="#BDBDBD"><b>관심분야:</b>
         <td>
            <input type = "checkbox" name="MEMBER_INTEREST" id = "hobby" value="컴퓨터">컴퓨터
            <input type = "checkbox" name="MEMBER_INTEREST" id = "hobby" value="인터넷">인터넷
            <input type = "checkbox" name="MEMBER_INTEREST" id = "hobby" value="여행">여행
            <input type = "checkbox" name="MEMBER_INTEREST" id = "hobby" value="영화감상">영화감상
         </td>
      </tr>
      <tr>
         <td align="center" bgcolor="#BDBDBD"><b>자기소개:</b></td>
         <td><textarea name="MEMBER_INTRO" rows="7" cols="70"></textarea></td>
      </tr>
   </table>

   <table width = "650" height="50" border="0" align="center" style="border: none;">
      <tr>
         <td colspan="2" align="center" height="50">
            <input type = "submit"  value="회원 가입">
            <input type = "reset" id = "reset" value = "다시 입력">
         </td>
      </tr>
   </table>
</form>
</body>
</html>