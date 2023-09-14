import { Navigate, Route, createBrowserRouter, createRoutesFromElements } from "react-router-dom"
import Layout from "./layouts/Layout"
import Job from "./job/Job"
import ErrorPage from "./job/ErrorPage"


const router = createBrowserRouter(createRoutesFromElements(
    <>
        <Route path='/' element={<Layout/>} >
            <Route index element={<Navigate to='jobs' replace={true}/>}/>
            <Route path="jobs" element={<Job/>} errorElement={<ErrorPage/>}/>
        </Route>
    </>
   
))

export {router}