import React, { useEffect, useState } from 'react'
import Sidebar from './Sidebar'
import JobListing from './JobListing'
import { FilterOptionContext, JobsContext } from './Context';
import { fetchAllJobs } from '../api/jobApi';

export default function Job() {
    //setting height of jobs
    useEffect(() => {
        const currElement = document.getElementsByClassName("job")[0];
        const prevSibling = currElement.previousElementSibling;
    
        if (prevSibling) {
          const previousSiblingEndingPosition = prevSibling.offsetTop + prevSibling.offsetHeight;
          const remainingViewportHeight = window.innerHeight - previousSiblingEndingPosition;
    
          // Set the calculated height as a style property
          currElement.style.height = remainingViewportHeight + 'px';
        }
      }, []);


      const [filterOption, setFilterOption] = useState();
      const [jobs, setJobs] = useState([]);

      useEffect(() => {
        const fetchData = async () => {

          try {
            const jobsData = await fetchAllJobs({
              pageNumber: 0,
              pageSize: 10,
              sortField: 'id',
              sortDirection: 'asc',
              filter: filterOption, 
            });

            setJobs(jobsData);
          } catch (error) {
            //todo
            console.error('Error fetching jobs:', error);
          }

        };

          fetchData();

      }, [filterOption]);

  return (
    <div className="job">
        <FilterOptionContext.Provider value={{filterOption, setFilterOption}}>
      <Sidebar filterOption={filterOption} setFilterOption={setFilterOption} />
      </FilterOptionContext.Provider>
    
      <JobsContext.Provider value={{jobs, setJobs}}>
        <JobListing />
      </JobsContext.Provider>
  </div>
  )
}
