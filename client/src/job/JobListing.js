import React, { useContext, useEffect, useState } from 'react';
import JobCard from './JobCard';
import './job.css';
import { JobsContext } from './Context';

export default function JobPage() {
  const { jobs } = useContext(JobsContext);
  const [jobData, setJobData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const data = await jobs; // Wait for the Promise to resolve
        setJobData(Object.values(data));
      } catch (error) {
        console.error('Error fetching jobs:', error);
      }
    };

    fetchData();
  }, [jobs]);

  
  return (
    <div className='joblisting'>

      {
        !jobData || jobData.length === 0 ? (
          <div className="no-content">
            <p>No Jobs Available</p>
          </div>
        ) :
        jobData && jobData.map((job) => (
        <JobCard

        key={job.id}
        id={job.id}
        title={job.title} 
        company_id={job.company_id} 
        requirement={job.requirement}
        skills={job.requirement} 
        description = {job.description}
        />
      ))
    }
    </div>

  );
}