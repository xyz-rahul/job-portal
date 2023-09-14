import React, { useContext } from 'react';
import JobCard from './JobCard';
import './job.css';
import { JobsContext } from './Context';

export default function JobPage() {
  const { jobs } = useContext(JobsContext);

  // Check if the 'jobs' array exists and has elements
  if (!jobs || jobs.length === 0) {
    const jobsNotFoundError = {
      code: 204,
      message: "No Jobs Available",
      detail: null
    }
    throw jobsNotFoundError;
  }
  
  return (
    <div className='joblisting'>

      {jobs && jobs.map((job) => (
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