import axios from "axios";
import { BASE_URL } from "./apiUtils";

export const fetchCompany = async function({id}){
    try{
        const response = await axios.get(`${BASE_URL}/companies/${id}`);
        const data = response.data;
        return data;
    }catch(error){
        //todo
        console.log(error);
    }
}