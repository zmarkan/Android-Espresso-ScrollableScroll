
/*
curl --location --request POST 'https://circleci.com/api/v2/project/<vcs-type>/<organization-name-or-id>/<project-name-or-id>/schedule' \
--header 'circle-token: <your-cci-token>' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "trigger name",
    "description": "some description",
    "attribution-actor": "system",
    "parameters": {
      "branch": "master",
      "run-schedule": true
    },
    "timetable": {
        "per_hour": 3,
        "hours_of_day": [1,5],
        "days_of_week": ["MON", "WED"]
    }
}'
*/

const axios = require('axios').default;
require('dotenv').config()

const API_BASE_URL = "https://circleci.com/api/v2/project"
const vcs = process.env.VCS_TYPE
const org = process.env.ORG_NAME
const project = process.env.PROJECT_ID
const token = process.env.CIRCLECI_TOKEN

const postScheduleEndpoint = `${API_BASE_URL}/${vcs}/${org}/${project}/schedule`

async function setupNightlySchedule(){

    let res = await axios.post(postScheduleEndpoint,
        {
            name: "Nightly build",
            description: "Builds and pushes a new build to Sonatype snapshots every night. Like clockwork.",
                "attribution-actor": "system",
                "parameters": {
                  "branch": "main",
                  "run-schedule": true
                },
                "timetable": {
                    "per_hour": 1,
                    "hours_of_day": [1],
                    "days_of_week": ["TUE", "WED", "THU", "FRI", "SAT"]
                }
        },
        {
            headers: { 'circle-token': token }
        }
    )

    console.log(res.data)
}

setupNightlySchedule()
