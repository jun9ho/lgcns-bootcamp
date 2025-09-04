import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import styled from "styled-components";
import MainPage from "./component/blog/page/MainPage";
import BlogWritePage from "./component/blog/page/BlogWritePage";
import BlogReadPage from "./component/blog/page/BlogReadPage";
import SignupPage from "./component/blog/page/SingUpPage";
import LoginPage from "./component/blog/page/LoginPage";

const DivTitleText = styled.p`
    font-size   : 24px;
    font-weight : bold;
    text-align  : center ;
`;

const BlogApp = () => {
    return (
        <BrowserRouter>
            <DivTitleText>
                AM Inspire Camp 3th
            </DivTitleText>
            <Routes>
                <Route path="/" element={<SignupPage />} />
                <Route path="/login" element={<LoginPage />} />
                <Route path="/blog" element={<MainPage />} />
                <Route path="/blog-write" element={<BlogWritePage />} />
                <Route path="/blog-read/:blogId" element={<BlogReadPage />} />
            </Routes>
        </BrowserRouter>
    );
}

export default BlogApp; 