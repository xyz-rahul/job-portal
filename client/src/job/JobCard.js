import React, { useEffect, useState } from 'react';
import './jobCard.css';
import { fetchCompany } from '../api/companyApi';

export default function JobCard(props) {

    const {id, title, company_id, requirement,description} = props;
    const [companyName, setCompanyName] = useState('a');

    // Fetch company data based on company_id
    useEffect(() => {
        const fetchCompanyData = async ()=>{
            try {
                const companyData = await fetchCompany({ id: company_id });
                setCompanyName(companyData.name);
            } catch (error) {
                //todo
                console.log(error);
            };
        }
        fetchCompanyData(); 

    }, [company_id]);

    return (
        <div className="cookie-card">

         <span className="title">{title}</span>
         <span className="company">{companyName}</span>
         
         <div className="skill-container">
            {requirement.map(e=> <div key={e}className="skill">{e}</div>)}
        </div>

        <p className="description">
            {description}
        </p>
     
        <div className="actions">
            <button className="save">
                Save Job
            </button>
            <button className="accept">
                Apply Job
            </button>
        </div>
    </div>
    )
}
