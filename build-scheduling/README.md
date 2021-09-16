# CircleCI build scheduling API call samples

Sample API calls for the CircleCI scheduled pipelines:

- Set up a new nightly build for project - `setup_nightly_build.js`
- Get all scheduled builds in project - `get_schedules.js`
- Delete a scheduled build - `delete_schedule.js`

## How to use:

- Have the project building on [CircleCI](https://circleci.com)
- `npm install`
- Copy `.env.sample` into `.env`, and populate with your CircleCI token, and project and organisation details
- Run one of the scripts in `package.json`, such as `npm run setup_nightly_build`. 

