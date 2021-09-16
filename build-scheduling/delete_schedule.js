
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

const API_BASE_URL = "https://circleci.com/api/v2/schedule"
const vcs = process.env.VCS_TYPE
const org = process.env.ORG_NAME
const project = process.env.PROJECT_ID
const token = process.env.CIRCLECI_TOKEN

const schedule_id = '1ae3b5dc-86bd-484d-99fe-17fbf3af7352'
const deleteScheduleEndpoint = `${API_BASE_URL}/${schedule_id}`

async function deleteScheduleById(){

    let res = await axios.delete(deleteScheduleEndpoint,
        {
            headers: { 'circle-token': token }
        }
    )

    console.log(res.data)
}

deleteScheduleById()
