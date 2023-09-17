import React, { useEffect, useState } from 'react'
import JobListing from './JobListing'
import { FilterOptionContext, JobsContext } from './Context';
import SideBarPanel from './SideBarPanel';
import { BASE_URL } from '../api/apiUtils';
import axios from 'axios';

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


    const [filterOption, setFilterOption] = useState({});
    const [jobs, setJobs] = useState([]);

    useEffect(() => {

      const filterKeys = Object.keys(filterOption);
      const filterParams = filterKeys.map((key) => {
        const values = filterOption[key];
        const encodedValues = values.map(encodeURIComponent).join('&' + key + '=');
        return `${key}=${encodedValues}`;
      }).join('&');

      // Add the filterParams to your base URL
      const filteredURL = `${BASE_URL}/jobs/all?${filterParams}`;

      // Now you can use this filteredURL for your API request
      setJobs(fetchJobs(filteredURL));

    }, [filterOption]);

    const fetchJobs = async (URL) => {
      try {
        const response = await axios.get(URL);
        console.log(response.data.content);
        return response.data.content;
      } catch (error) {

      }
    }

  return (
    <div className="job">
      <FilterOptionContext.Provider value={{filterOption, setFilterOption}}>
          <SideBarPanel filterOption={filterOption} setFilterOption={setFilterOption} />
      </FilterOptionContext.Provider> 
    
      <JobsContext.Provider value={{jobs, setJobs}}>
        <JobListing />
      </JobsContext.Provider>
  </div>
  )
}
