import React, { useState } from "react";
import styled from "styled-components";
import api from "../../../api/axios";
import { useLocation, useNavigate } from "react-router-dom";

// Container
const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f2f2f2;
`;

// Form Box
const FormWrapper = styled.div`
  background-color: white;
  padding: 40px;
  border-radius: 10px;
  box-shadow: 0px 8px 16px rgba(0,0,0,0.1);
  width: 400px;
`;

// Title
const Title = styled.h2`
  text-align: center;
  margin-bottom: 20px;
  color: #333;
`;

// Input
const Input = styled.input`
  width: 100%;
  padding: 12px;
  margin-bottom: 15px;
  border-radius: 6px;
  border: 1px solid #ccc;
  font-size: 16px;

  &:focus {
    outline: none;
    border-color: #007bff;
    box-shadow: 0 0 5px rgba(0,123,255,0.3);
  }
`;

// Button
const Button = styled.button`
  width: 100%;
  padding: 12px;
  background-color: #007bff;
  color: white;
  border: none;
  font-size: 16px;
  border-radius: 6px;
  cursor: pointer;
  margin-top: 10px;

  &:hover {
    background-color: #0056b3;
  }

  &:disabled {
    background-color: #aaa;
    cursor: not-allowed;
  }
`;

// SignUp Component
const SignUpPage = () => {
  const [email, setEmail]     = useState('');
  const [passwd, setPasswd]   = useState('');
  const [confirmPasswd, setConfirmPasswd]   = useState('');
  const [name, setName]       = useState('');
  const moveUrl = useNavigate();

  const handleSubmit = (e, email, passwd, name) => {
    console.log(">>>>>>", name, passwd, email);

    console.log("회원가입 정보:");
    // 여기서 API 호출 가능
    // 1. 유효성 체크 
    // if(isEmpty(email) || !validate("EMAIL", email)) {
    //   alert("이메일을 확인해주세요.");
    //   return;
    // }
    // if(isEmpty(passwd) || !validate("PASSWORD", passwd)) {
    //   alert("비밀번호를 확인해주세요.");
    //   return;
    // }
    // if (passwd !== confirmPasswd) {
    //   alert("비밀번호가 일치하지 않습니다.");
    //   return;
    // }
    // 2. 정상적인 데이터 입력시 화면전환 /login 이동
    api.post("/api/v2/inspire/user/signup", {
      email, passwd, name
    }).then((res) => {
      if(res.status === 204){
        moveUrl("/");
      }
    }).catch((err) => {
      console.error("회원가입 오류:", err);
    });
  };
  
  const isEmpty = (value) => {
    if(value == null) return true;
    return value.trim() === '';
  };
  const validate = (type, value) => {
    let reg;
    switch(type) {
      case "EMAIL":
        reg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        return reg.test(value);
      case "PASSWORD":
        // 최소 8자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자
        reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
        return reg.test(value);
      default:
        return false;
    }
  }
  return (
    <Container>
      <FormWrapper>
        <Title>회원가입</Title>
        <Input
          type="email"
          name="email"
          placeholder="이메일"
          value={email}
          onChange={(e)=> setEmail(e.target.value)}
          required
        />
        <Input
          type="password"
          name="passwd"
          placeholder="비밀번호"
          value={passwd}
          onChange={(e)=> setPasswd(e.target.value)}
          required
        />
        <Input
          type="password"
          name="confirmPasswd"
          placeholder="비밀번호 확인"
          value={confirmPasswd}
          onChange={(e) => setConfirmPasswd(e.target.value)}
          required
        />
        <Input
          type="text"
          name="name"
          placeholder="이름"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
        <Button onClick={(e) => handleSubmit(e, email, passwd, name)}>가입하기</Button>
      </FormWrapper>
    </Container>
  );
};

export default SignUpPage;