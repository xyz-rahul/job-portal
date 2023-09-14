import React, { useContext } from 'react';
import JobCard from './JobCard';
import './job.css';
import { JobsContext } from './Context';


export default function JobPage() {
  const { jobs } = useContext(JobsContext);

  
  return (
    <div className='joblisting'>

      {jobs.map((job) => (
        <JobCard

        key={job.id}
        id={job.id}
        title={job.title} 
        company_id={job.company_id} 
        requirement={job.requirement}
        skills={job.requirement} 
        description = {job.description}
        />
      ))}
    </div>

  );
}