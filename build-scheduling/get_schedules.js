const axios = require('axios').default;
require('dotenv').config()

const API_BASE_URL = "https://circleci.com/api/v2/project"
const vcs = process.env.VCS_TYPE
const org = process.env.ORG_NAME
const project = process.env.PROJECT_ID
const token = process.env.CIRCLECI_TOKEN

const getSchedulesEndpoint = `${API_BASE_URL}/${vcs}/${org}/${project}/schedule/`

async function getSchedules(){

    let res = await axios.get(getSchedulesEndpoint, {
        headers:
            {
                'circle-token': `${token}`
            }
    })

    console.log(res.data)
}

getSchedules()
