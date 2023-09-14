import axios from 'axios';
import { BASE_URL } from './apiUtils';

const JOB_URL = `${BASE_URL}/jobs`
export const fetchAllJobs = async function(params) {
    const {pageNumber, pageSize, sortField, sortDirection, filter} = params;

    try{
        const response = await axios.get(`${JOB_URL}/all`,{
            params:{
                page: pageNumber,
                size: pageSize,
                sortField: sortField,
                sortDirection: sortDirection,
            }
        });

        const data = response.data.content;
        return data;
    }catch(error){
        //todo
        console.log(error);
    }
}