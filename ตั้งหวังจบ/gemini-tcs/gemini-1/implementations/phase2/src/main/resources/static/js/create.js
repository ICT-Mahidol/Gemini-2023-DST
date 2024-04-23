const nameInput = document.getElementById("creatorname");

fetch("http://localhost:8080/usersname?id=" + localStorage.getItem("userid"))
  .then((response) => response.text())
  .then((data) => {
    const fullName = data.trim();
    console.log(fullName);
    nameInput.value = fullName;
  });

function checkUserId() {
  if (localStorage.getItem("userid") == 0) {
    location.replace("/");
  }
  if (localStorage.getItem("permission") == 2) {
    location.replace("/observer");
  }
  console.log(localStorage.getItem("userid"));
}

window.onload = checkUserId;

async function logout() {
  localStorage.setItem("check_login", false);
  localStorage.setItem("userid", 0);
  location.replace("/");
}

function addStarSystemOptions() {
  const starSystemSelect = document.getElementById("starsystem");

  fetch(
    "http://localhost:8080/starsystems?id=" + localStorage.getItem("userid")
  ) // Replace with your actual API endpoint
    .then((response) => response.json())
    .then((data) => {
      // Remove existing options from the select element
      starSystemSelect.innerHTML = "";

      // Add a default option
      const defaultOption = document.createElement("option");
      defaultOption.value = "";
      defaultOption.text = "Please select";
      defaultOption.disabled = true;
      defaultOption.selected = true;
      starSystemSelect.add(defaultOption);

      // Add an option for each star system in the response
      data.forEach((starSystem) => {
        const option = document.createElement("option");
        option.value = starSystem;
        option.text = starSystem;
        starSystemSelect.add(option);
      });
    })
    .catch((error) => {
      console.error("Error fetching star systems:", error);
    });
}

// Call the function to add the star system options to the select element
addStarSystemOptions();

const telescopeLocationSelect = document.getElementById("telescopelocation");

fetch(
  "http://localhost:8080/telescopelocations?id=" +
    localStorage.getItem("userid")
) // Replace with your actual API endpoint
  .then((response) => response.json())
  .then((data) => {
    for (let i = 0; i < data.length; i++) {
      const option = document.createElement("option");
      option.value = data[i];
      option.textContent = data[i];
      telescopeLocationSelect.appendChild(option);
    }
  })
  .catch((error) => {
    console.error("Error fetching telescope locations:", error);
  });

const form = document.querySelector("#progress-form");

form.addEventListener("submit", (event) => {
  event.preventDefault();

  const formData = new FormData(form);
  const formValues = Object.fromEntries(formData.entries());

  const startdate = formData.get("startdate")
  const enddate = formData.get("enddate")

  const parts = startdate.split("-");
  const formattedStartdate = `${parts[2]}/${parts[1]}/${parts[0]}` +" " + formData.get("starttime")+":00";

  const partss = enddate.split("-");
  const formattedEnddate = `${partss[2]}/${partss[1]}/${partss[0]}` + " "+ formData.get("endtime")+":00";

  console.log(`${formattedStartdate}`);
  console.log(`${formattedEnddate}`);

  const url = "http://localhost:8080/scienceplans?id="+
  localStorage.getItem("userid");
  console.log
  const data = {
    submitter: "",
    funding: parseInt(formData.get("funding")),
    objective: formData.get("objectives"),
    starSystem: formData.get("starsystem"),
    telescopeLocation: formData.get("telescopelocation"),
    startdate:  formattedStartdate,
    enddate: formattedEnddate,
    fileType: formData.get("fileType"),
    fileQuality: formData.get("fileQuality"),
    colorType: formData.get("colorType"),
    contrast: parseInt(formData.get("contrast")),
    brightness: parseInt(formData.get("brightness")),
    saturation: parseInt(formData.get("saturation")),
    highlight: parseInt(formData.get("highlights")),
    exposure: parseInt(formData.get("exposure")),
    shadow: parseInt(formData.get("shadows")),
    whites: parseInt(formData.get("whites")),
    blacks: parseInt(formData.get("blacks")),
    luminance: parseInt(formData.get("luminance")),
    hue: parseInt(formData.get("hue")),
  };
  
  console.log(data)

  fetch(url, {
    method: "POST",
    body: JSON.stringify(data),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.text();
    })
    .then((data) => {
      console.log("Science plan submitted:", data);
    })
    .catch((error) => {
      console.error("Error submitting science plan:", error);
    });
});

function ready(fn) {
  if (
    document.readyState === "complete" ||
    document.readyState === "interactive"
  ) {
    setTimeout(fn, 1);
    document.removeEventListener("DOMContentLoaded", fn);
  } else {
    document.addEventListener("DOMContentLoaded", fn);
  }
}

ready(function () {
  // Global Constants

  const progressForm = document.getElementById("progress-form");

  const tabItems = progressForm.querySelectorAll('[role="tab"]'),
    tabPanels = progressForm.querySelectorAll('[role="tabpanel"]');

  let currentStep = 0;

  const isValidPhone = (val) => {
    const regex = new RegExp(
      /^[-. (]*(\d{3})[-. )]*(\d{3})[-. ]*(\d{4})(?: *x(\d+))?$/
    );

    return regex.test(val);
  };


  const isValidEmail = (val) => {
    const regex = new RegExp(
      /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    );

    return regex.test(val);
  };


  const validateText = (field) => {
    const val = field.value.trim();

    if (val === "" && field.required) {
      return {
        isValid: false,
      };
    } else {
      return {
        isValid: true,
      };
    }
  };


  const validateSelect = (field) => {
    const val = field.value.trim();

    if (val === "" && field.required) {
      return {
        isValid: false,
        message: "Please select an option from the dropdown menu.",
      };
    } else {
      return {
        isValid: true,
      };
    }
  };


  const validateGroup = (fieldset) => {
    const choices = fieldset.querySelectorAll(
      'input[type="radio"], input[type="checkbox"]'
    );

    let isRequired = false,
      isChecked = false;

    for (const choice of choices) {
      if (choice.required) {
        isRequired = true;
      }

      if (choice.checked) {
        isChecked = true;
      }
    }

    if (!isChecked && isRequired) {
      return {
        isValid: false,
        message: "Please make a selection.",
      };
    } else {
      return {
        isValid: true,
      };
    }
  };



  const validateChoice = (field) => {
    return validateGroup(field.closest("fieldset"));
  };


  const validatePhone = (field) => {
    const val = field.value.trim();

    if (val === "" && field.required) {
      return {
        isValid: false,
      };
    } else if (val !== "" && !isValidPhone(val)) {
      return {
        isValid: false,
        message: "Please provide a valid US phone number.",
      };
    } else {
      return {
        isValid: true,
      };
    }
  };

  const validateEmail = (field) => {
    const val = field.value.trim();

    if (val === "" && field.required) {
      return {
        isValid: false,
      };
    } else if (val !== "" && !isValidEmail(val)) {
      return {
        isValid: false,
        message: "Please provide a valid email address.",
      };
    } else {
      return {
        isValid: true,
      };
    }
  };

  const validateNumber = (field) => {
    const val = field.value.trim();

    if (val === "" && field.required) {
      return {
        isValid: false,
      };
    } else if (isNaN(val)) {
      return {
        isValid: false,
        message: "Please provide a valid number.",
      };
    } else {
      return {
        isValid: true,
      };
    }
  };
  const validateDate = (field) => {
    const val = field.value.trim();
  
    // check if the field is required and empty
    if (val === "" && field.required) {
      return {
        isValid: false,
        message: "Date is required.",
      };
    }
  
    // check if the input is a valid date
    const date = new Date(val);
    if (isNaN(date.getTime())) {
      return {
        isValid: false,
        message: "Invalid date. Please enter a valid date.",
      };
    }
  
    // check if start date is before end date
    const startDate = document.getElementById("startdate").valueAsDate;
    const endDate = document.getElementById("enddate").valueAsDate;
    if (startDate && endDate && startDate >= endDate) {
      return {
        isValid: false,
        message: "Start date must be before end date",
      };
    }
  
    // format the date to "DD/MM/YYYY" format
    const day = date.getDate().toString().padStart(2, "0");
    const month = (date.getMonth() + 1).toString().padStart(2, "0");
    const year = date.getFullYear();
    const formattedDate = `${day}/${month}/${year}`;
  
    // if all checks pass, return isValid true
    return {
      isValid: true,
      value: formattedDate,
    };
  };
  
  

  const validateTime = (field) => {
    const val = field.value.trim();
  
    // Regular expression to match the time format of HH:MM:SS
    const regex = /^([01]\d|2[0-3]):([0-5]\d)$/;
  
    if (val === "" && field.required) {
      return {
        isValid: false,
        message: "This field is required.",
      };
    } else if (!regex.test(val)) {
      return {
        isValid: false,
        message: "Invalid time format. Please use the format HH:MM:SS",
      };
    } else {
      return {
        isValid: true,
      };
    }
  };
    

  /*****************************************************************************
   * Expects a Node (field or fieldset).
   *
   * Returns an object describing the field's overall validity, as well as
   * a possible error message where additional information may be helpful for
   * the user to complete the field.
   */

  const getValidationData = (field) => {
    switch (field.type) {
      case "text":
      case "textarea":
        return validateText(field);
      case "select-one":
        return validateSelect(field);
      case "fieldset":
        return validateGroup(field);
      case "radio":
      case "checkbox":
        return validateChoice(field);
      case "tel":
        return validatePhone(field);
      case "email":
        return validateEmail(field);
      case "number":
        return validateNumber(field);
      case "date":
        return validateDate(field);
      case "time":
        return validateTime(field);
      default:
        throw new Error(
          `The provided field type '${field.tagName}:${field.type}' is not supported in this form.`
        );
    }
  };

  /*****************************************************************************
   * Expects a Node (field or fieldset).
   *
   * Returns the field's overall validity based on conditions set within
   * `getValidationData()`.
   */

  const isValid = (field) => {
    return getValidationData(field).isValid;
  };

  /*****************************************************************************
   * Expects an integer.
   *
   * Returns a promise that either resolves if all fields in a given step are
   * valid, or rejects and returns invalid fields for further processing.
   */

  const validateStep = (currentStep) => {
    const fields = tabPanels[currentStep].querySelectorAll(
      'fieldset, input:not([type="radio"]):not([type="checkbox"]), select, textarea'
    );

    const invalidFields = [...fields].filter((field) => {
      return !isValid(field);
    });

    return new Promise((resolve, reject) => {
      if (invalidFields && !invalidFields.length) {
        resolve();
      } else {
        reject(invalidFields);
      }
    });
  };

  // Form Error and Success

  const FIELD_PARENT_CLASS = "form__field",
    FIELD_ERROR_CLASS = "form__error-text";

  /*****************************************************************************
   * Expects a Node (fieldset) that contains any number of radio or checkbox
   * input elements, and a string representing the group's validation status.
   */

  function updateChoice(fieldset, status, errorId = "") {
    const choices = fieldset.querySelectorAll(
      '[type="radio"], [type="checkbox"]'
    );

    for (const choice of choices) {
      if (status) {
        choice.setAttribute("aria-invalid", "true");
        choice.setAttribute("aria-describedby", errorId);
      } else {
        choice.removeAttribute("aria-invalid");
        choice.removeAttribute("aria-describedby");
      }
    }
  }

  /*****************************************************************************
   * Expects a Node (field or fieldset) that either has the class name defined
   * by `FIELD_PARENT_CLASS`, or has a parent with that class name. Optional
   * string defines the error message.
   *
   * Builds and appends an error message to the parent element, or updates an
   * existing error message.
   *
   * https://www.davidmacd.com/blog/test-aria-describedby-errormessage-aria-live.html
   */

  function reportError(
    field,
    message = "Please complete this required field."
  ) {
    const fieldParent = field.closest(`.${FIELD_PARENT_CLASS}`);

    if (progressForm.contains(fieldParent)) {
      let fieldError = fieldParent.querySelector(`.${FIELD_ERROR_CLASS}`),
        fieldErrorId = "";

      if (!fieldParent.contains(fieldError)) {
        fieldError = document.createElement("p");

        if (field.matches("fieldset")) {
          fieldErrorId = `${field.id}__error`;

          updateChoice(field, true, fieldErrorId);
        } else if (field.matches('[type="radio"], [type="checkbox"]')) {
          fieldErrorId = `${field.closest("fieldset").id}__error`;

          updateChoice(field.closest("fieldset"), true, fieldErrorId);
        } else {
          fieldErrorId = `${field.id}__error`;

          field.setAttribute("aria-invalid", "true");
          field.setAttribute("aria-describedby", fieldErrorId);
        }

        fieldError.id = fieldErrorId;
        fieldError.classList.add(FIELD_ERROR_CLASS);

        fieldParent.appendChild(fieldError);
      }

      fieldError.textContent = message;
    }
  }

  /*****************************************************************************
   * Expects a Node (field or fieldset) that either has the class name defined
   * by `FIELD_PARENT_CLASS`, or has a parent with that class name.
   *
   * https://www.davidmacd.com/blog/test-aria-describedby-errormessage-aria-live.html
   */

  function reportSuccess(field) {
    const fieldParent = field.closest(`.${FIELD_PARENT_CLASS}`);

    if (progressForm.contains(fieldParent)) {
      const fieldError = fieldParent.querySelector(`.${FIELD_ERROR_CLASS}`);

      if (fieldParent.contains(fieldError)) {
        if (field.matches("fieldset")) {
          updateChoice(field, false);
        } else if (field.matches('[type="radio"], [type="checkbox"]')) {
          updateChoice(field.closest("fieldset"), false);
        } else {
          field.removeAttribute("aria-invalid");
          field.removeAttribute("aria-describedby");
        }

        fieldParent.removeChild(fieldError);
      }
    }
  }

  /*****************************************************************************
   * Expects a Node (field or fieldset).
   *
   * Reports the field's overall validity to the user based on conditions set
   * within `getValidationData()`.
   */

  function reportValidity(field) {
    const validation = getValidationData(field);

    if (!validation.isValid && validation.message) {
      reportError(field, validation.message);
    } else if (!validation.isValid) {
      reportError(field);
    } else {
      reportSuccess(field);
    }
  }

  // Form Progression

  /*****************************************************************************
   * Resets the state of all tabs and tab panels.
   */

  function deactivateTabs() {
    // Reset state of all tab items
    tabItems.forEach((tab) => {
      tab.setAttribute("aria-selected", "false");
      tab.setAttribute("tabindex", "-1");
    });

    // Reset state of all panels
    tabPanels.forEach((panel) => {
      panel.setAttribute("hidden", "");
    });
  }

  /*****************************************************************************
   * Expects an integer.
   *
   * Shows the desired tab and its associated tab panel, then updates the form's
   * current step to match the tab's index.
   */

  function activateTab(index) {
    const thisTab = tabItems[index],
      thisPanel = tabPanels[index];

    // Close all other tabs
    deactivateTabs();

    // Focus the activated tab for accessibility
    thisTab.focus();

    // Set the interacted tab to active
    thisTab.setAttribute("aria-selected", "true");
    thisTab.removeAttribute("tabindex");

    // Display the associated tab panel
    thisPanel.removeAttribute("hidden");

    // Update the current step with the interacted tab's index value
    currentStep = index;
  }

  /*****************************************************************************
   * Expects an event from a click listener.
   */

  function clickTab(e) {
    activateTab([...tabItems].indexOf(e.currentTarget));
  }

  /*****************************************************************************
   * Expects an event from a keydown listener.
   */

  function arrowTab(e) {
    const { keyCode, target } = e;

    /**
     * If the current tab has an enabled next/previous sibling, activate it.
     * Otherwise, activate the tab at the beginning/end of the list.
     */

    const targetPrev = target.previousElementSibling,
      targetNext = target.nextElementSibling,
      targetFirst = target.parentElement.firstElementChild,
      targetLast = target.parentElement.lastElementChild;

    const isDisabled = (node) => node.hasAttribute("aria-disabled");

    switch (keyCode) {
      case 37: // Left arrow
        if (progressForm.contains(targetPrev) && !isDisabled(targetPrev)) {
          activateTab(currentStep - 1);
        } else if (!isDisabled(targetLast)) {
          activateTab(tabItems.length - 1);
        }
        break;
      case 39: // Right arrow
        if (progressForm.contains(targetNext) && !isDisabled(targetNext)) {
          activateTab(currentStep + 1);
        } else if (!isDisabled(targetFirst)) {
          activateTab(0);
        }
        break;
    }
  }

  /*****************************************************************************
   * Expects a boolean.
   *
   * Updates the visual state of the progress bar and makes the next tab
   * available for interaction (if there is a next tab).
   */

  // Immediately attach event listeners to the first tab (happens only once)
  tabItems[0].addEventListener("click", clickTab);
  tabItems[0].addEventListener("keydown", arrowTab);

  function handleProgress(isComplete) {
    const currentTab = tabItems[currentStep],
      nextTab = tabItems[currentStep + 1];

    if (isComplete) {
      currentTab.setAttribute("data-complete", "true");

      /**
       * Verify that there is, indeed, a next tab before modifying or listening
       * to it. In case we've reached the last item in the tablist.
       */

      if (progressForm.contains(nextTab)) {
        nextTab.removeAttribute("aria-disabled");

        nextTab.addEventListener("click", clickTab);
        nextTab.addEventListener("keydown", arrowTab);
      }
    } else {
      currentTab.setAttribute("data-complete", "false");
    }
  }

  // Form Interactions

  /*****************************************************************************
   * Returns a function that only executes after a delay.
   *
   * https://davidwalsh.name/javascript-debounce-function
   */

  const debounce = (fn, delay = 500) => {
    let timeoutID;

    return (...args) => {
      if (timeoutID) {
        clearTimeout(timeoutID);
      }

      timeoutID = setTimeout(() => {
        fn.apply(null, args);
        timeoutID = null;
      }, delay);
    };
  };

  /*****************************************************************************
   * Waits 0.5s before reacting to any input events. This reduces the frequency
   * at which the listener is fired, making the errors less "noisy". Improves
   * both performance and user experience.
   */

  progressForm.addEventListener(
    "input",
    debounce((e) => {
      const { target } = e;

      validateStep(currentStep)
        .then(() => {
          // Update the progress bar (step complete)
          handleProgress(true);
        })
        .catch(() => {
          // Update the progress bar (step incomplete)
          handleProgress(false);
        });

      // Display or remove any error messages
      reportValidity(target);
    })
  );

  /****************************************************************************/

  progressForm.addEventListener("click", (e) => {
    const { target } = e;

    if (target.matches('[data-action="next"]')) {
      validateStep(currentStep)
        .then(() => {
          // Update the progress bar (step complete)
          handleProgress(true);

          // Progress to the next step
          activateTab(currentStep + 1);
        })
        .catch((invalidFields) => {
          // Update the progress bar (step incomplete)
          handleProgress(false);

          // Show errors for any invalid fields
          invalidFields.forEach((field) => {
            reportValidity(field);
          });

          // Focus the first found invalid field for the user
          invalidFields[0].focus();
        });
    }

    if (target.matches('[data-action="prev"]')) {
      // Revisit the previous step
      activateTab(currentStep - 1);
    }
  });

  // Form Submission

  /*****************************************************************************
   * Returns the user's IP address.
   */



  /*****************************************************************************
   * POSTs to the specified endpoint.
   */

  async function postData(url = "", data = {}) {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    if (!response.ok) {
      throw new Error(response.statusText);
    }

    return response.json();
  }

  /****************************************************************************/

  function disableSubmit() {
    const submitButton = progressForm.querySelector('[type="submit"]');

    if (progressForm.contains(submitButton)) {
      // Update the state of the submit button
      submitButton.setAttribute("disabled", "");
      submitButton.textContent = "Submitting...";
    }
  }

  /****************************************************************************/

  function handleSuccess() {
    const thankYou = progressForm.querySelector("#progress-form__thank-you");

    // Clear all HTML Nodes that are not the thank you panel
    while (progressForm.firstElementChild !== thankYou) {
      progressForm.removeChild(progressForm.firstElementChild);
    }

    thankYou.removeAttribute("hidden");

    // Logging the response from httpbin for quick verification

  }

  /****************************************************************************/

  function handleError(error) {
    const submitButton = progressForm.querySelector('[type="submit"]');

    if (progressForm.contains(submitButton)) {
      const errorText = document.createElement("p");

      // Reset the state of the submit button
      submitButton.removeAttribute("disabled");
      submitButton.textContent = "Submit";

      // Display an error message for the user
      errorText.classList.add("m-0", "form__error-text");
      errorText.textContent = `Sorry, your submission could not be processed.
        Please try again. If the issue persists, please contact our support
        team. Error message: ${error}`;

      submitButton.parentElement.prepend(errorText);
    }
  }

  /****************************************************************************/

  progressForm.addEventListener("submit", (e) => {
    // Prevent the form from submitting
    e.preventDefault();

    // Get the API endpoint using the form action attribute
    const form = e.currentTarget,
      API = new URL(form.action);

    validateStep(currentStep)
      .then(() => {
        // Indicate that the submission is working
        disableSubmit();



            setTimeout(() => {
              handleError(error);
            }, 5000); // An artificial delay to show the state of the submit button
            handleSuccess();

      })
      .catch((invalidFields) => {
        // Show errors for any invalid fields
        invalidFields.forEach((field) => {
          reportValidity(field);
        });

        // Focus the first found invalid field for the user
        invalidFields[0].focus();
      });
  });
});
