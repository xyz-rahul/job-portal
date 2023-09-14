import { Navigate, Route, createBrowserRouter, createRoutesFromElements } from "react-router-dom"
import Layout from "./layouts/Layout"
import Job from "./job/Job"


const router = createBrowserRouter(createRoutesFromElements(
    <>
        <Route path='/' element={<Layout/>}>
            <Route index element={<Navigate to='jobs' replace={true}/>}/>
            <Route path="jobs" element={<Job/>}/>
        </Route>
    </>
   
))

export {router}