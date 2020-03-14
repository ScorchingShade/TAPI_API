# TAPI API  
TAPI API or The Awesome Powerloader Integrator API is a web-based Vert.x API aimed at providing receipting solutions. It uses MongoDB cloud cluster to create seamless db connectivity experience.
TAPI API uses vert.x technology coupled with spring boot architecture to give you fast, scalable, concurrent and reliable experience.

---

## “fetchData” API call: 
`The data needs to be sent in post-call.
The format for the post data needs to be as:
{
  "id": [
    "a1",
    "a2"
  ]
}`

---

## “delteData” API call: 
`The data needs to be sent in post-call. 
The format for the post data needs to be as:
{
  "id": [
    "a1",
    "a2"
  ]
}`

---

## “generate” API call:
`The generate API is configured to send the data in a post-call to the TAPI API service.
The API service is currently modelled on a receipt generating template. The essential parameters are:
`


ReceiptModel


Parameters     | Value type
-------- | -----
id| Receipt Id
name| Payer name
address| Payer address
amount| Receipt Amount
payment_type| Cash/Credit/Debit
date| Receipt date
receiver| Payee Name


## Author
### [Ankush Sharma](https://scorchingshade.github.io/) 
- [LinkedIn](https://linkedin.com/in/ankush-sharma-a9b24a37/)
- [Facebook](https://www.facebook.com/kushuas)
- [Medium](https://medium.com/@ankushsharma_70830)
- **Mail** - ankushors789@gmail.com

I code, I write, I hack, I preach. <br />
Always available for any opportunities! (Pssst...I am really passionate about cybersecurity).

