import React from 'react';
import './navbar.css';
import { Link } from 'react-router-dom';



export default function Navbar() {

    const openSideNav = ()=>{
        document.getElementById("sideNavigation").style.width = "250px";
    }

    const closeSideNav = ()=>{
        document.getElementById("sideNavigation").style.width = "0";
    }



    return (
        <div className="nav">

            <div className="nav-left">
                <div className="nav-head">
                    findJob
                </div>

                <div className="nav-links">
                    <a>Home</a>
                    <a>Jobs</a>
                    <a>Companies</a>

                </div>
            </div>

            <div className="nav-right">
                <div className="inputBox_container">
                    <svg
                        className="search_icon"
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 48 48"
                        alt="search icon"
                    >
                        <path d="M46.599 46.599a4.498 4.498 0 0 1-6.363 0l-7.941-7.941C29.028 40.749 25.167 42 21 42 9.402 42 0 32.598 0 21S9.402 0 21 0s21 9.402 21 21c0 4.167-1.251 8.028-3.342 11.295l7.941 7.941a4.498 4.498 0 0 1 0 6.363zM21 6C12.717 6 6 12.714 6 21s6.717 15 15 15c8.286 0 15-6.714 15-15S29.286 6 21 6z"></path>
                    </svg>
                    <input
                        className="inputBox"
                        id="inputBox"
                        type="text"
                        placeholder="Search For Products"
                    />


                    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
                </div>


                <div className="user" onClick={openSideNav}>
                    <svg width="30" height="30" id="icoOpen">
                        <path d="M0,5 30,5" stroke="#ddd" strokeWidth="5" />
                        <path d="M0,14 30,14" stroke="#ddd" strokeWidth="5" />
                        <path d="M0,23 30,23" stroke="#ddd" strokeWidth="5" />
                    </svg>
                </div>


                <div id="sideNavigation" className="sidenav">
                    <a  className="closebtn" onClick={closeSideNav}>
                        ×
                    </a>
                    <a href="#">About</a>
                    <a href="#">Features</a>
                    <a href="#">Contact Us</a>
                </div>





            </div>
        </div>
    )
}
